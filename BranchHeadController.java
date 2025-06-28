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

import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.service.BranchHeadService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchHeadController {
	@Autowired
	BranchHeadService branchHeadService;
	
	@Operation(summary = "Save Branch Head", description = "API to create a new Branch Head")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Branch Head successfully created"),
	    @ApiResponse(responseCode = "400", description = "Invalid branch head data provided")
	})
	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}
	
	@Operation(summary = "Fetch Branch Head", description = "API to fetch Branch Head by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch Head successfully fetched"),
	    @ApiResponse(responseCode = "404", description = "Branch Head not found")
	})
	@GetMapping("/fetchBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.fetchBranchHeadById(branchHeadId);
	}
	
	@Operation(summary = "Delete Branch Head", description = "API to delete Branch Head by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch Head successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Branch Head not found to delete")
	})
	@DeleteMapping("/deleteBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.deleteBranchHeadById(branchHeadId);
	}
	
	@Operation(summary = "Update Branch Head", description = "API to update Branch Head details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch Head successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Branch Head not found to update")
	})
	@PutMapping("/updateBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(@RequestParam int oldBranchHeadId,@RequestBody BranchHead newbBranchHead) {
		return branchHeadService.updateBranchHeadById(oldBranchHeadId, newbBranchHead);
	}
	
	@Operation(summary = "Fetch All Branch Heads", description = "API to retrieve all Branch Heads")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Branch Heads successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No branch heads found")
	})
	@GetMapping("/fetchAllBranchHead")
	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadService.fetchAllBranchHead();
	}


}
