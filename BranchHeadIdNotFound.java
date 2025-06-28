package com.project.hospital_management_system.exception;

public class BranchHeadIdNotFound extends RuntimeException {
	
    private String message = "BranchHead ID not found in the DB";

    public String getMessage() {
        return message;
    }
}
