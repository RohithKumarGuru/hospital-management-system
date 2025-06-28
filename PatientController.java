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

import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.service.PatientService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@Operation(summary = "Save Patient", description = "API to create a new Patient")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Patient successfully created"),
	    @ApiResponse(responseCode = "400", description = "Invalid patient data provided")
	})
	@PostMapping("/savePatient")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	@Operation(summary = "Fetch Patient", description = "API to fetch Patient by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Patient successfully fetched"),
	    @ApiResponse(responseCode = "404", description = "Patient not found")
	})
	@GetMapping("/fetchPatientById")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(@RequestParam int patientId) {
		return patientService.fetchPatientById(patientId);
	}
	
	@Operation(summary = "Delete Patient", description = "API to delete Patient by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Patient successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Patient not found to delete")
	})
	@DeleteMapping("/deletePatientById")
	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(@RequestParam int patientId) {
		return patientService.deletePatientById(patientId);
	}
	
	@Operation(summary = "Update Patient", description = "API to update Patient details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Patient successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Patient not found to update")
	})
	@PutMapping("/updatePatientById")
	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(@RequestParam int oldPatientId,@RequestBody Patient newpPatient) {
		return patientService.updatePatientById(oldPatientId, newpPatient);
	}
	
	@Operation(summary = "Fetch All Patients", description = "API to retrieve all Patients")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Patients successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No patients found")
	})
	@GetMapping("/fetchAllPatient")
	public List<Patient> fetchAllPatient(){
		return patientService.fetchAllPatient();
	}
	
	@GetMapping("/addExistingPatientToExistingPayment")
	public Patient addExistingPatientToExistingPayment(@RequestParam int patientId,@RequestParam int paymentId) {
		return patientService.addExistingPatientToExistingPayment(patientId, paymentId);
	}
	
	@PutMapping("/addExistingPatientToExistingPrescription")
	public Patient addExistingPatientToExistingPrescription(@RequestParam int patientId,@RequestParam int prescriptionId) {
		return patientService.addExistingPatientToExistingPrescription(patientId, prescriptionId);
	}
	
	@PutMapping("/addNewPrescriptionToExistingPatient")
	public Patient addNewPrescriptionToExistingPatient(@RequestParam int patientId,@RequestBody Prescription newPrescription) {
		return patientService.addNewPrescriptionToExistingPatient(patientId, newPrescription);
	}


}
