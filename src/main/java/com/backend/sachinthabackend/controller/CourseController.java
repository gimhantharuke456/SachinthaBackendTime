package com.backend.sachinthabackend.controller;

import com.backend.sachinthabackend.model.Course;
import com.backend.sachinthabackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private  CourseService courseService;

    // Create a new course
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }

    // Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.findAllCourses();
        return ResponseEntity.ok(courses);
    }

    // Get a single course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        return courseService.findCourseById(id)
                .map(course -> ResponseEntity.ok(course))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a course
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails)
                .map(updatedCourse -> ResponseEntity.ok().body(updatedCourse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id) {
        if (courseService.deleteCourse(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
