package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.DoctorDao;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class DoctorService {
	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	ResponseStructure<Doctor> responseStructure;
	
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully doctor created in DB");
		responseStructure.setData(doctorDao.saveDoctor(doctor));
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorById(int doctorId) {
	      Doctor doctor = doctorDao.fetchDoctorById(doctorId);
	      responseStructure.setStatusCode(HttpStatus.FOUND.value());
	      responseStructure.setMessage("Successfully doctor fetched from DB");
	      responseStructure.setData(doctor);
	      return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
	  }
	
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctorById(int doctorId) {
		Doctor doctor = doctorDao.fetchDoctorById(doctorId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully doctor deleted from DB");
		responseStructure.setData(doctorDao.deleteDoctorById(doctorId));
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctorById(int oldDoctorId,Doctor newDoctor) {
		Doctor doctor = doctorDao.fetchDoctorById(oldDoctorId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully doctor updated in DB");
		responseStructure.setData(doctorDao.updateDoctorById(oldDoctorId, newDoctor));
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Doctor> fetchAllDoctor(){
		return doctorDao.fetchAllDoctor();
	}
	
	public Doctor addExistingDoctorToExistingPatient(int doctorId,int patientId) {
		return doctorDao.addExistingDoctorToExistingPatient(doctorId, patientId);
	}
	
	public Doctor addNewPatientToExistingDoctor(int doctorId,Patient newPatient) {
		return doctorDao.addNewPatientToExistingDoctor(doctorId, newPatient);
	}

}
