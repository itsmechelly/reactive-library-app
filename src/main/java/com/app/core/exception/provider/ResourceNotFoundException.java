package com.app.core.exception.provider;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String id) {
        super("NoContentException, library with " + id + " not found.");
    }
}
