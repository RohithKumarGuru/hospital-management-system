package com.project.hospital_management_system.exception;

public class EmployeeIdNotFound extends RuntimeException {
	
    private String message = "Employee ID not found in the DB";

    public String getMessage() {
        return message;
    }
}