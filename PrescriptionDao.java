package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Prescription;
import com.project.hospital_management_system.exception.PrescriptionIdNotFound;
import com.project.hospital_management_system.repo.PrescriptionRepo;

@Repository
public class PrescriptionDao {
	@Autowired
	PrescriptionRepo prescriptionRepo;
	
	public Prescription savePrescription(Prescription prescription) {
		return prescriptionRepo.save(prescription);
	}
	
    public Prescription fetchPrescriptionById(int prescriptionId) {
        Optional<Prescription> optional = prescriptionRepo.findById(prescriptionId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new PrescriptionIdNotFound();
        }
    }
	
	public Prescription deletePrescriptionById(int prescriptionId) {
		Prescription prescription=fetchPrescriptionById(prescriptionId);
		prescriptionRepo.delete(prescription);
		return prescription;
	}
	
	public Prescription updatePrescriptionById(int oldPrescriptionId,Prescription newPrescription) {
		newPrescription.setPrescriptionId(oldPrescriptionId);
		return prescriptionRepo.save(newPrescription);
	}
	
	public List<Prescription> fetchAllPrescription(){
		return prescriptionRepo.findAll();
	}

}
