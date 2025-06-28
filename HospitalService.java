package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.HospitalDao;
import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Hospital;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	HospitalDao hospitalDao;
	
	@Autowired
	ResponseStructure<Hospital> responseStructure;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully hospital created in DB");
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
	}
	
	   public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(int hospitalId) {
	        Hospital hospital = hospitalDao.fetchHospitalById(hospitalId);
	        responseStructure.setStatusCode(HttpStatus.FOUND.value());
	        responseStructure.setMessage("Successfully hospital fetched from DB");
	        responseStructure.setData(hospital);
	        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
	    }
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int hospitalId) {
		Hospital hospital = hospitalDao.fetchHospitalById(hospitalId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully hospital deleted from DB");
		responseStructure.setData(hospitalDao.deleteHospitalById(hospitalId));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(int oldHospitalId,Hospital newhHospital) {
		Hospital hospital = hospitalDao.fetchHospitalById(oldHospitalId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully hospital updated in DB");
		responseStructure.setData(hospitalDao.updateHospitalById(oldHospitalId, newhHospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Hospital> fetchAllHospital(){
		return hospitalDao.fetchAllHospital();
	}
	
	public Hospital addExistingHospitalToExistingBranch(int hospitalId,int branchId) {
		return hospitalDao.addExistingHospitalToExistingBranch(hospitalId, branchId);
	}
	
	public Hospital addNewBranchToExistingHospital(int hospitalId,Branch newBranch) {
		return hospitalDao.addNewBranchToExistingHospital(hospitalId, newBranch);
	}


}
