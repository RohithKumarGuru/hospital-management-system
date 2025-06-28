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

import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.service.AddressService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@Operation(summary = "Save Address", description = "API to create a new Address")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Address successfully created"),
	    @ApiResponse(responseCode = "400", description = "Invalid address data provided")
	})
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@Operation(summary = "Fetch Address", description = "API to fetch Address by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Address successfully fetched"),
	    @ApiResponse(responseCode = "404", description = "Address not found")
	})
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}
	
	@Operation(summary = "Delete Address", description = "API to delete Address by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Address successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Address not found to delete")
	})
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}
	
	@Operation(summary = "Update Address", description = "API to update Address details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Address successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Address not found to update")
	})
	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
	
	@Operation(summary = "Fetch All Addresses", description = "API to retrieve all Addresses")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Addresses successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No addresses found")
	})
	@GetMapping("/fetchAllAddress")
	public List<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}

}
