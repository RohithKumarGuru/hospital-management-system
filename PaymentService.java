package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.PaymentDao;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.dto.Payment;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;
	
	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully payment created in DB");
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int paymentId) {
        Payment payment = paymentDao.fetchPaymentById(paymentId);
        responseStructure.setStatusCode(HttpStatus.FOUND.value());
        responseStructure.setMessage("Successfully payment fetched from DB");
        responseStructure.setData(payment);
        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
    }
	
	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully payment deleted from DB");
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(int oldPaymentId,Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldPaymentId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully payment updated in DB");
		responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Payment> fetchAllPayment(){
		return paymentDao.fetchAllPayment();
	}

}
