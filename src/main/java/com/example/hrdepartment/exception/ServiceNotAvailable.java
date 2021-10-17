package com.example.hrdepartment.exception;

public class ServiceNotAvailable extends RuntimeException {
    public ServiceNotAvailable(String message) {
        super(message);
    }
}
