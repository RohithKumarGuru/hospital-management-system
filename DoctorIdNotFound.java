package com.project.hospital_management_system.exception;

public class DoctorIdNotFound extends RuntimeException {
	
    private String message = "Doctor ID not found in the DB";

    public String getMessage() {
        return message;
    }
}