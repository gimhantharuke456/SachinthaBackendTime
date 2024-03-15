package com.backend.sachinthabackend.service;

import com.backend.sachinthabackend.model.Timetable;
import com.backend.sachinthabackend.repositary.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public Timetable createTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    public List<Timetable> findAllTimetables() {
        return timetableRepository.findAll();
    }

    public Optional<Timetable> findTimetableById(String id) {
        return timetableRepository.findById(id);
    }

    public Optional<Timetable> updateTimetable(String id, Timetable updatedTimetable) {
        return timetableRepository.findById(id).map(timetable -> {
            timetable.setCourseId(updatedTimetable.getCourseId());
            timetable.setStartTime(updatedTimetable.getStartTime());
            timetable.setEndTime(updatedTimetable.getEndTime());
            timetable.setLocation(updatedTimetable.getLocation());
            timetable.setFacultyId(updatedTimetable.getFacultyId());
            return timetableRepository.save(timetable);
        });
    }

    public boolean deleteTimetable(String id) {
        return findTimetableById(id).map(timetable -> {
            timetableRepository.delete(timetable);
            return true;
        }).orElse(false);
    }
}
