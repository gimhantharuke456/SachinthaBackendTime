package com.backend.sachinthabackend.service;

import com.backend.sachinthabackend.model.Enrollment;

import com.backend.sachinthabackend.repositary.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> findAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> findEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }

    public Optional<Enrollment> updateEnrollment(String id, Enrollment updatedEnrollment) {
        return enrollmentRepository.findById(id).map(enrollment -> {
            enrollment.setStudentId(updatedEnrollment.getStudentId());
            enrollment.setCourseId(updatedEnrollment.getCourseId());
            enrollment.setStatus(updatedEnrollment.getStatus());
            return enrollmentRepository.save(enrollment);
        });
    }

    public boolean deleteEnrollment(String id) {
        return enrollmentRepository.findById(id).map(enrollment -> {
            enrollmentRepository.delete(enrollment);
            return true;
        }).orElse(false);
    }
}
