package com.project.hospital_management_system.exception;

public class PaymentIdNotFound extends RuntimeException {
    private String message = "Payment ID not found in the DB";

    public String getMessage() {
        return message;
    }
}