package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.Hospital;
import com.project.hospital_management_system.exception.HospitalIdNotFound;
import com.project.hospital_management_system.repo.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	HospitalRepo hospitalRepo;
	
	@Autowired
	BranchDao branchDao;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}
	
    public Hospital fetchHospitalById(int hospitalId) {
        Optional<Hospital> optional = hospitalRepo.findById(hospitalId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new HospitalIdNotFound();
        }
    }
	
	public Hospital deleteHospitalById(int hospitalId) {
		Hospital hospital=fetchHospitalById(hospitalId);
		hospitalRepo.delete(hospital);
		return hospital;
	}
	
	public Hospital updateHospitalById(int oldHospitalId,Hospital newhHospital) {
		newhHospital.setHospitalId(oldHospitalId);
		return hospitalRepo.save(newhHospital);
	}
	
	public List<Hospital> fetchAllHospital(){
		return hospitalRepo.findAll();
	}
	
	public Hospital addExistingHospitalToExistingBranch(int hospitalId,int branchId) {
		Hospital hospital=fetchHospitalById(hospitalId);
		Branch branch=branchDao.fetchBranchById(branchId);
		List<Branch> list=hospital.getBranch();
		list.add(branch);
		hospital.setBranch(list);
		return saveHospital(hospital);
	}
	
	public Hospital addNewBranchToExistingHospital(int hospitalId,Branch newBranch) {
		Hospital hospital=fetchHospitalById(hospitalId);
		List<Branch> list=hospital.getBranch();
		list.add(newBranch);
		hospital.setBranch(list);
		return saveHospital(hospital);
	}
	
	

}
