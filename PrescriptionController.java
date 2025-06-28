package com.project.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.service.PrescriptionService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PrescriptionController {
	@Autowired
	PrescriptionService prescriptionService;
	
	@Operation(summary = "Save All Prescriptions", description = "API to save a list of Prescriptions")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Prescriptions successfully saved"),
	    @ApiResponse(responseCode = "400", description = "Invalid prescription data provided")
	})
	@PostMapping("/savePrescription")
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@RequestBody Prescription prescription) {
		return prescriptionService.savePrescription(prescription);
	}
	
	@Operation(summary = "Fetch Prescription", description = "API to fetch a Prescription by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Prescription successfully fetched"),
	    @ApiResponse(responseCode = "404", description = "Prescription not found")
	})
	@GetMapping("/fetchPrescriptionById")
	public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionById(@RequestParam int prescriptionId) {
		return prescriptionService.fetchPrescriptionById(prescriptionId);
	}
	
	@Operation(summary = "Delete Prescription", description = "API to delete a Prescription by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Prescription successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Prescription not found to delete")
	})
	@DeleteMapping("/deletePrescriptionById")
	public ResponseEntity<ResponseStructure<Prescription>> deletePrescriptionById(@RequestParam int prescriptionId) {
		return prescriptionService.deletePrescriptionById(prescriptionId);
	}
	
	@Operation(summary = "Update Prescription", description = "API to update a Prescription by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Prescription successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Prescription not found to update")
	})
	@PutMapping("/updatePrescriptionById")
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescriptionById(@RequestParam int oldPrescriptionId,@RequestBody Prescription newPrescription) {
		return prescriptionService.updatePrescriptionById(oldPrescriptionId, newPrescription);
	}
	
	@Operation(summary = "Fetch All Prescriptions", description = "API to fetch all Prescriptions")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Prescriptions successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No Prescriptions found")
	})
	@GetMapping("/fetchAllPrescription")
	public List<Prescription> fetchAllPrescription(){
		return prescriptionService.fetchAllPrescription();
	}
	

}
