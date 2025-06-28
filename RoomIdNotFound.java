package com.project.hospital_management_system.exception;

public class RoomIdNotFound extends RuntimeException {
	
    private String message = "Room ID not found in the DB";

    public String getMessage() {
        return message;
    }
}
