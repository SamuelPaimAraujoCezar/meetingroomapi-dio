package com.digital.crud.saladereuniao.saladereuniao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID= 1L;

    public ResourceNotFoundException(Long id) {
        super("Room not found with ID " + id);
    }
}