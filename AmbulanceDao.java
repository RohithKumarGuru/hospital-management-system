package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.exception.AmbulanceIdNotFound;
import com.project.hospital_management_system.repo.AmbulanceRepo;

@Repository
public class AmbulanceDao {
	@Autowired
	AmbulanceRepo ambulanceRepo;
	
	public Ambulance saveAmbulance(Ambulance ambulance) {
		return ambulanceRepo.save(ambulance);
	}
	
	public Ambulance fetchAmbulanceById(int ambulanceId) {
        Optional <Ambulance> optional = ambulanceRepo.findById(ambulanceId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new AmbulanceIdNotFound();
        }
    }
	
	public Ambulance deleteAmbulanceById(int ambulanceId) {
		Ambulance ambulance=fetchAmbulanceById(ambulanceId);
		ambulanceRepo.delete(ambulance);
		return ambulance;
	}
	
	public Ambulance updateAmbulanceById(int oldAmbulanceId,Ambulance newAmbulance) {
		newAmbulance.setAmbulanceId(oldAmbulanceId);
		return ambulanceRepo.save(newAmbulance);
	}
	
	public List<Ambulance> fetchAllAmbulance() {
		return ambulanceRepo.findAll();
	}

}
