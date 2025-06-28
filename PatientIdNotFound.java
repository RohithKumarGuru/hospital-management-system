package com.project.hospital_management_system.exception;

public class PatientIdNotFound extends RuntimeException {
	
    private String message = "Patient ID not found in the DB";

    public String getMessage() {
        return message;
    }
}
