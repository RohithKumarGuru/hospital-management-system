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

import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Hospital;
import com.project.hospital_management_system.service.HospitalService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	@Operation(summary = "Save Hospital", description = "API to create a new Hospital")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Hospital successfully created"),
	    @ApiResponse(responseCode = "400", description = "Invalid hospital data provided")
	})
	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@Operation(summary = "Fetch Hospital", description = "API to fetch Hospital by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Hospital successfully fetched"),
	    @ApiResponse(responseCode = "404", description = "Hospital not found")
	})
	@GetMapping("/fetchHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(@RequestParam int hospitalId) {
		return hospitalService.fetchHospitalById(hospitalId);
	}
	
	@Operation(summary = "Delete Hospital", description = "API to delete Hospital by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Hospital successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Hospital not found to delete")
	})
	@DeleteMapping("/deleteHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@RequestParam int hospitalId) {
		return hospitalService.deleteHospitalById(hospitalId);
	}
	
	@Operation(summary = "Update Hospital", description = "API to update Hospital details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Hospital successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Hospital not found to update")
	})
	@PutMapping("/updateHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@RequestParam int oldHospitalId,@RequestBody Hospital newhHospital) {
		return hospitalService.updateHospitalById(oldHospitalId, newhHospital);
	}
	
	@Operation(summary = "Fetch All Hospitals", description = "API to retrieve all Hospitals")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Hospitals successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No hospitals found")
	})
	@GetMapping("/fetchAllHospital")
	public List<Hospital> fetchAllHospital(){
		return hospitalService.fetchAllHospital();
	}
	
	@PutMapping("/addExistingHospitalToExistingBranch")
	public Hospital addExistingHospitalToExistingBranch(@RequestParam int hospitalId,@RequestParam int branchId) {
		return hospitalService.addExistingHospitalToExistingBranch(hospitalId, branchId);
	}
	
	@PutMapping("/addNewBranchToExistingHospital")
	public Hospital addNewBranchToExistingHospital(@RequestParam int hospitalId,@RequestBody Branch newBranch) {
		return hospitalService.addNewBranchToExistingHospital(hospitalId, newBranch);
	}


}
