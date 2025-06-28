package com.project.hospital_management_system.exception;

	public class AmbulanceIdNotFound extends RuntimeException {
	    private String message = "Ambulance ID not found in the DB";

	    public String getMessage() {
	        return message;
	    }

}
