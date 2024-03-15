package com.backend.sachinthabackend.repositary;

import com.backend.sachinthabackend.model.Resource;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Hidden
@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {

}
