package com.university.course_manager_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found") // Devuelve un 404 automaticamente
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message, Long id) {
        super(String.format("%s with id %d not found", message, id));
    }

}
