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

import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.service.BranchService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;
	
	@Operation(summary = "Save Branch", description = "API to create a new Branch")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Branch successfully created"),
	    @ApiResponse(responseCode = "400", description = "Invalid branch data provided")
	})
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	
	@Operation(summary = "Fetch Branch", description = "API to fetch Branch by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch successfully fetched"),
	    @ApiResponse(responseCode = "404", description = "Branch not found")
	})
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}
	
	@Operation(summary = "Delete Branch", description = "API to delete Branch by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Branch not found to delete")
	})
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}
	
	@Operation(summary = "Update Branch", description = "API to update Branch details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Branch not found to update")
	})
	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int oldBranchId,@RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}
	
	@Operation(summary = "Fetch All Branches", description = "API to retrieve all Branches")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branches successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No branches found")
	})
	@GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}
	
	@PutMapping("/addExistingBranchToExistingAddress")
	public Branch addExistingBranchToExistingAddress(@RequestParam int branchId,@RequestParam int addressId) {
		return branchService.addExistingBranchToExistingAddress(branchId, addressId);
	}
	
	@PutMapping("/addExistingBranchToExistingBranchHead")
	public Branch addExistingBranchToExistingBranchHead(@RequestParam int branchId,@RequestParam int branchHeadId) {
		return branchService.addExistingBranchToExistingBranchHead(branchId, branchHeadId);
	}
	
	@PutMapping("/addExistingBranchToExistingAmbulance")
	public Branch addExistingBranchToExistingAmbulance(@RequestParam int branchId,@RequestParam int ambulanceId) {
		return branchService.addExistingBranchToExistingAmbulance(branchId, ambulanceId);
	}
	
	@PutMapping("/addNewAmbulanceToExistingBranch")
	public Branch addNewAmbulanceToExistingBranch(@RequestParam int branchId,@RequestBody Ambulance newAmbulance) {
		return branchService.addNewAmbulanceToExistingBranch(branchId, newAmbulance);
	}
	
	@PutMapping("/addExistingBranchToExistingDoctor")
	public Branch addExistingBranchToExistingDoctor(@RequestParam int branchId,@RequestParam int doctorId) {
		return branchService.addExistingBranchToExistingDoctor(branchId, doctorId);
	}
	
	@PutMapping("/addNewDoctorToExistingBranch")
	public Branch addNewDoctorToExistingBranch(@RequestParam int branchId,@RequestBody Doctor newDoctor) {
		return branchService.addNewDoctorToExistingBranch(branchId, newDoctor);
	}
	
	@PutMapping("/addExistingBranchToExistingPatient")
	public Branch addExistingBranchToExistingPatient(@RequestParam int branchId,@RequestParam int patientId) {
		return branchService.addExistingBranchToExistingPatient(branchId, patientId);
	}
	
	@PutMapping("/addNewPatientToExistingBranch")
	public Branch addNewPatientToExistingBranch(@RequestParam int branchId,@RequestBody Patient newpPatient) {
		return branchService.addNewPatientToExistingBranch(branchId, newpPatient);
	}
	
	@PutMapping("/addExistingBranchToExistingRoom")
	public Branch addExistingBranchToExistingRoom(@RequestParam int branchId,@RequestParam int roomId) {
		return branchService.addExistingBranchToExistingRoom(branchId, roomId);
	}
	
	@PutMapping("/addNewRoomToExistingBranch")
	public Branch addNewRoomToExistingBranch(@RequestParam int branchId,@RequestBody Room newrRoom) {
		return branchService.addNewRoomToExistingBranch(branchId, newrRoom);
	}
	
	@PutMapping("/addExistingBranchToExistingEmployee")
	public Branch addExistingBranchToExistingEmployee(@RequestParam int branchId,@RequestParam int employeeId) {
		return branchService.addExistingBranchToExistingEmployee(branchId, employeeId);
	}
	
	@PutMapping("/addNewEmployeeToExistingBranch")
	public Branch addNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}



}
