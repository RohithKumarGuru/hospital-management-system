package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Payment;
import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.exception.PatientIdNotFound;
import com.project.hospital_management_system.repo.PatientRepo;

@Repository
public class PatientDao {
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	PrescriptionDao prescriptionDao;
	
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	  public Patient fetchPatientById(int patientId) {
	        Optional<Patient> optional = patientRepo.findById(patientId);
	        if (optional.isPresent()) {
	            return optional.get();
	        } else {
	            throw new PatientIdNotFound();
	        }
	    }
	
	public Patient deletePatientById(int patientId) {
		Patient patient=fetchPatientById(patientId);
		patientRepo.delete(patient);
		return patient;
	}
	
	public Patient updatePatientById(int oldPatientId,Patient newpPatient) {
		newpPatient.setPatientId(oldPatientId);
		return patientRepo.save(newpPatient);
	}
	
	public List<Patient> fetchAllPatient(){
		return patientRepo.findAll();
	}
	
	public Patient addExistingPatientToExistingPayment(int patientId,int paymentId) {
		Patient patient=fetchPatientById(patientId);
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		patient.setPayment(payment);
		return savePatient(patient);
	}
	
	public Patient addExistingPatientToExistingPrescription(int patientId,int prescriptionId) {
		Patient patient=fetchPatientById(patientId);
		Prescription prescription=prescriptionDao.fetchPrescriptionById(prescriptionId);
		List<Prescription> list=patient.getPrescription();
		list.add(prescription);
		patient.setPrescription(list);
		return savePatient(patient);
	}
	
	public Patient addNewPrescriptionToExistingPatient(int patientId,Prescription newPrescription) {
		Patient patient=fetchPatientById(patientId);
		List<Prescription> list=patient.getPrescription();
		list.add(newPrescription);
		patient.setPrescription(list);
		return savePatient(patient);
	}

}
