package com.backend.sachinthabackend.service;

import com.backend.sachinthabackend.model.Course;

import com.backend.sachinthabackend.repositary.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private  CourseRepository courseRepository;

    // Create a new course
    public Course createCourse(Course course) {
        // Additional logic before saving can be added here
        return courseRepository.save(course);
    }

    // Retrieve all courses
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    // Find a course by ID
    public Optional<Course> findCourseById(String id) {
        return courseRepository.findById(id);
    }

    // Update a course
    public Optional<Course> updateCourse(String id, Course courseDetails) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(courseDetails.getName());
                    course.setCode(courseDetails.getCode());
                    course.setDescription(courseDetails.getDescription());
                    course.setCredits(courseDetails.getCredits());
                    course.setAssignedFaculty(courseDetails.getAssignedFaculty());
                    return courseRepository.save(course);
                });
    }

    // Delete a course
    public boolean deleteCourse(String id) {
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return true;
                }).orElse(false);
    }
}
