    package com.backend.sachinthabackend.repositary;

    import com.backend.sachinthabackend.model.Course;
    import io.swagger.v3.oas.annotations.Hidden;
    import org.springframework.data.mongodb.repository.MongoRepository;
    import org.springframework.stereotype.Repository;

    @Hidden
    @Repository
    public interface CourseRepository extends MongoRepository<Course, String> {
    }
