package com.backend.sachinthabackend.controller;

import com.backend.sachinthabackend.model.Timetable;
import com.backend.sachinthabackend.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetables")
public class TimetableController {

    private final TimetableService timetableService;

    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @PostMapping
    public ResponseEntity<Timetable> createTimetable(@RequestBody Timetable timetable) {
        Timetable createdTimetable = timetableService.createTimetable(timetable);
        return ResponseEntity.ok(createdTimetable);
    }

    @GetMapping
    public ResponseEntity<List<Timetable>> getAllTimetables() {
        List<Timetable> timetables = timetableService.findAllTimetables();
        return ResponseEntity.ok(timetables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable String id) {
        return timetableService.findTimetableById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Timetable> updateTimetable(@PathVariable String id, @RequestBody Timetable timetable) {
        return timetableService.updateTimetable(id, timetable)
                .map(updatedTimetable -> ResponseEntity.ok().body(updatedTimetable))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTimetable(@PathVariable String id) {
        boolean isDeleted = timetableService.deleteTimetable(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
