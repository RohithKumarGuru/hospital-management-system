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

import com.project.hospital_management_system.dto.Payment;
import com.project.hospital_management_system.service.PaymentService;
import com.project.hospital_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@Operation(summary = "Save Payment", description = "API to save a new Payment")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Payment successfully recorded"),
	    @ApiResponse(responseCode = "400", description = "Invalid payment data provided")
	})
	@PostMapping("/savePayment")
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	
	@Operation(summary = "Fetch Payment", description = "API to fetch Payment by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Payment successfully fetched"),
	    @ApiResponse(responseCode = "404", description = "Payment not found")
	})
	@GetMapping("/fetchPaymentById")
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}
	
	@Operation(summary = "Delete Payment", description = "API to delete Payment by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Payment successfully deleted"),
	    @ApiResponse(responseCode = "404", description = "Payment not found to delete")
	})
	@DeleteMapping("/deletePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}
	
	@Operation(summary = "Update Payment", description = "API to update Payment details by ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Payment successfully updated"),
	    @ApiResponse(responseCode = "404", description = "Payment not found to update")
	})
	@PutMapping("/updatePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
	
	@Operation(summary = "Fetch All Payments", description = "API to retrieve all Payments")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Payments successfully fetched"),
	    @ApiResponse(responseCode = "204", description = "No payments found")
	})
	@GetMapping("/fetchAllPayment")
	public List<Payment> fetchAllPayment(){
		return paymentService.fetchAllPayment();
	}

}
