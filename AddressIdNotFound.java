package com.project.hospital_management_system.exception;

	public class AddressIdNotFound extends RuntimeException {
		
	    private String message = "Address ID not found in the DB";

	    public String getMessage() {
	        return message;
	    }

}
