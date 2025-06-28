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

import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.service.OwnerService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	
	@Operation(summary = "Save Owner", description = "API to create a new Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Owner successfully created"),
			@ApiResponse(responseCode = "400", description = "Invalid Owner data provided") })
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@Operation(summary = "Fetch Owner", description = "API to fetch the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Owner successfully fetched"),
			@ApiResponse(responseCode = "404", description = "owner not found in db") })
	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	
	@Operation(summary = "Delete Owner", description = "API to delete the Owner by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Owner successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Owner not found to delete")
	})
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}
	
	@Operation(summary = "Update Owner", description = "API to update the Owner details")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Owner successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Owner not found to update")
	})
	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
	
	@Operation(summary = "Fetch All Owners", description = "API to get the list of all Owners")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Owners successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No Owners found")
	})
	@GetMapping("/fetchAllOwner")
	public List<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}
	
	@PutMapping("/addExistingOwnerToExistingHospital")
	public Owner addExistingOwnerToExistingHospital(@RequestParam int ownerId,@RequestParam int hospitalId) {
		return ownerService.addExistingOwnerToExistingHospital(ownerId, hospitalId);
	}

}
