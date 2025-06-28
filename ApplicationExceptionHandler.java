package com.project.hospital_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.hospital_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
     public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found in the DB");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFound(AddressIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Address not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AmbulanceIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ambulanceIdNotFound(AmbulanceIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Ambulance not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Branch not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchHeadIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchHeadIdNotFound(BranchHeadIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("BranchHead not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DoctorIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> doctorIdNotFound(DoctorIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Doctor not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> employeeIdNotFound(EmployeeIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Employee not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HospitalIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> hospitalIdNotFound(HospitalIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Hospital not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PatientIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> patientIdNotFound(PatientIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Patient not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> paymentIdNotFound(PaymentIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Payment not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PrescriptionIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> prescriptionIdNotFound(PrescriptionIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Prescription not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RoomIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> roomIdNotFound(RoomIdNotFound ex) {
	    responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    responseStructure.setMessage("Room not found in DB");
	    responseStructure.setData(ex.getMessage());
	    return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}


}
