package com.backend.sachinthabackend.service;

import com.backend.sachinthabackend.model.Resource;
import com.backend.sachinthabackend.repositary.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public List<Resource> findAllResources() {
        return resourceRepository.findAll();
    }

    public Optional<Resource> findResourceById(String id) {
        return resourceRepository.findById(id);
    }

    public Optional<Resource> updateResource(String id, Resource resourceDetails) {
        return findResourceById(id).map(resource -> {
            resource.setType(resourceDetails.getType());
            resource.setLocation(resourceDetails.getLocation());
            resource.setAvailable(resourceDetails.isAvailable());
            return resourceRepository.save(resource);
        });
    }

    public boolean deleteResource(String id) {
        return findResourceById(id).map(resource -> {
            resourceRepository.delete(resource);
            return true;
        }).orElse(false);
    }
}
