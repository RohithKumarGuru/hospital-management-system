package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.AmbulanceDao;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class AmbulanceService {
	@Autowired
	AmbulanceDao ambulanceDao;
	
	@Autowired
	ResponseStructure<Ambulance> responseStructure;
	
	public ResponseEntity<ResponseStructure<Ambulance>> saveAmbulance(Ambulance ambulance) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully ambulance created in DB");
		responseStructure.setData(ambulanceDao.saveAmbulance(ambulance));
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Ambulance>> fetchAmbulanceById(int ambulanceId) {
        Ambulance ambulance = ambulanceDao.fetchAmbulanceById(ambulanceId);
        responseStructure.setStatusCode(HttpStatus.FOUND.value());
        responseStructure.setMessage("Successfully ambulance fetched from DB");
        responseStructure.setData(ambulance);
        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
    }
	
	public ResponseEntity<ResponseStructure<Ambulance>> deleteAmbulanceById(int ambulanceId) {
		Ambulance ambulance = ambulanceDao.fetchAmbulanceById(ambulanceId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully ambulance deleted from DB");
		responseStructure.setData(ambulanceDao.deleteAmbulanceById(ambulanceId));
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Ambulance>> updateAmbulanceById(int oldAmbulanceId,Ambulance newAmbulance) {
		Ambulance ambulance = ambulanceDao.fetchAmbulanceById(oldAmbulanceId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully ambulance updated in DB");
		responseStructure.setData(ambulanceDao.updateAmbulanceById(oldAmbulanceId, newAmbulance));
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Ambulance> fetchAllAmbulance() {
		return ambulanceDao.fetchAllAmbulance();
	}


}
