package com.project.hospital_management_system.exception;

public class HospitalIdNotFound extends RuntimeException {
    private String message = "Hospital ID not found in the DB";

    public String getMessage() {
        return message;
    }
}