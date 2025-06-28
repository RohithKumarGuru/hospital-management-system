package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.PatientDao;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Payment;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class PatientService {
	@Autowired
	PatientDao patientDao;
	
	@Autowired
	ResponseStructure<Patient> responseStructure;
	
	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully patient created in DB");
		responseStructure.setData(patientDao.savePatient(patient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.CREATED);
	}
	
	 public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(int patientId) {
	        Patient patient = patientDao.fetchPatientById(patientId);
	        responseStructure.setStatusCode(HttpStatus.FOUND.value());
	        responseStructure.setMessage("Successfully patient fetched from DB");
	        responseStructure.setData(patient);
	        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
	    }
	
	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(int patientId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully patient deleted from DB");
		responseStructure.setData(patientDao.deletePatientById(patientId));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(int oldPatientId,Patient newpPatient) {
		Patient patient = patientDao.fetchPatientById(oldPatientId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully patient updated in DB");
		responseStructure.setData(patientDao.updatePatientById(oldPatientId, newpPatient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Patient> fetchAllPatient(){
		return patientDao.fetchAllPatient();
	}
	
	public Patient addExistingPatientToExistingPayment(int patientId,int paymentId) {
		return patientDao.addExistingPatientToExistingPayment(patientId, paymentId);
	}
	
	public Patient addExistingPatientToExistingPrescription(int patientId,int prescriptionId) {
		return patientDao.addExistingPatientToExistingPrescription(patientId, prescriptionId);
	}
	
	public Patient addNewPrescriptionToExistingPatient(int patientId,Prescription newPrescription) {
		return patientDao.addNewPrescriptionToExistingPatient(patientId, newPrescription);
	}


}
