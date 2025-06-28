package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.exception.DoctorIdNotFound;
import com.project.hospital_management_system.repo.DoctorRepo;

@Repository
public class DoctorDao {
	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
	PatientDao patientDao;
	
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	public Doctor fetchDoctorById(int doctorId) {
        Optional<Doctor> optional = doctorRepo.findById(doctorId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new DoctorIdNotFound();
        }
    }
	
	public Doctor deleteDoctorById(int doctorId) {
		Doctor doctor=fetchDoctorById(doctorId);
		doctorRepo.delete(doctor);
		return doctor;
	}
	
	public Doctor updateDoctorById(int oldDoctorId,Doctor newDoctor) {
		newDoctor.setDoctorId(oldDoctorId);
		return doctorRepo.save(newDoctor);
	}
	
	public List<Doctor> fetchAllDoctor(){
		return doctorRepo.findAll();
	}
	
	public Doctor addExistingDoctorToExistingPatient(int doctorId,int patientId) {
		Doctor doctor=fetchDoctorById(doctorId);
		Patient patient=patientDao.fetchPatientById(patientId);
		List<Patient> list=doctor.getPatient();
		list.add(patient);
		doctor.setPatient(list);
		return saveDoctor(doctor);
	}
	
	public Doctor addNewPatientToExistingDoctor(int doctorId,Patient newPatient) {
		Doctor doctor=fetchDoctorById(doctorId);
		List<Patient> list=doctor.getPatient();
		list.add(newPatient);
		doctor.setPatient(list);
		return saveDoctor(doctor);
	}

}
