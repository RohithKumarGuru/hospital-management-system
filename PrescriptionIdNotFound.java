package com.project.hospital_management_system.exception;

public class PrescriptionIdNotFound extends RuntimeException {
	
    private String message = "Prescription ID not found in the DB";

    public String getMessage() {
        return message;
    }
}