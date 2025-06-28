package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.BranchDao;
import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully branch created in DB");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
        Branch branch = branchDao.fetchBranchById(branchId);
        responseStructure.setStatusCode(HttpStatus.FOUND.value());
        responseStructure.setMessage("Successfully branch fetched from DB");
        responseStructure.setData(branch);
        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
    }
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully branch deleted from DB");
		responseStructure.setData(branchDao.deleteBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId,Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully branch updated in DB");
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Branch> fetchAllBranch() {
		return branchDao.fetchAllBranch();
	}
	
	public Branch addExistingBranchToExistingAddress(int branchId,int addressId) {
		return branchDao.addExistingBranchToExistingAddress(branchId, addressId);
	}
	
	public Branch addExistingBranchToExistingBranchHead(int branchId,int branchHeadId) {
		return branchDao.addExistingBranchToExistingBranchHead(branchId, branchHeadId);
	}
	
	public Branch addExistingBranchToExistingAmbulance(int branchId,int ambulanceId) {
		return branchDao.addExistingBranchToExistingAmbulance(branchId, ambulanceId);
	}
	
	public Branch addNewAmbulanceToExistingBranch(int branchId,Ambulance newAmbulance) {
		return branchDao.addNewAmbulanceToExistingBranch(branchId, newAmbulance);
	}
	
	public Branch addExistingBranchToExistingDoctor(int branchId,int doctorId) {
		return branchDao.addExistingBranchToExistingDoctor(branchId, doctorId);
	}
	
	public Branch addNewDoctorToExistingBranch(int branchId,Doctor newDoctor) {
		return branchDao.addNewDoctorToExistingBranch(branchId, newDoctor);
	}
	
	public Branch addExistingBranchToExistingPatient(int branchId,int patientId) {
		return branchDao.addExistingBranchToExistingPatient(branchId, patientId);
	}
	
	public Branch addNewPatientToExistingBranch(int branchId,Patient newpPatient) {
		return branchDao.addNewPatientToExistingBranch(branchId, newpPatient);
	}
	
	public Branch addExistingBranchToExistingRoom(int branchId,int roomId) {
		return branchDao.addExistingBranchToExistingRoom(branchId, roomId);
	}
	
	public Branch addNewRoomToExistingBranch(int branchId,Room newrRoom) {
		return branchDao.addNewRoomToExistingBranch(branchId, newrRoom);
	}
	
	public Branch addExistingBranchToExistingEmployee(int branchId,int employeeId) {
		return branchDao.addExistingBranchToExistingEmployee(branchId, employeeId);
	}
	
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
		return branchDao.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}



}
