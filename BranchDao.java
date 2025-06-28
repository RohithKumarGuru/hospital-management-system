package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.dto.Ambulance;
import com.project.hospital_management_system.dto.Branch;
import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.dto.Doctor;
import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.dto.Hospital;
import com.project.hospital_management_system.dto.Patient;
import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.exception.BranchIdNotFound;
import com.project.hospital_management_system.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	AmbulanceDao ambulanceDao;
	
	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	PatientDao patientDao;
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	
	 public Branch fetchBranchById(int branchId) {
	        Optional<Branch> optional = branchRepo.findById(branchId);
	        if (optional.isPresent()) {
	            return optional.get();
	        } else {
	            throw new BranchIdNotFound();
	        }
	    }
	
	public Branch deleteBranchById(int branchId) {
		Branch branch=fetchBranchById(branchId);
		 branchRepo.delete(branch);
		 return branch;
	}
	
	public Branch updateBranchById(int oldBranchId,Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}
	
	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}
	
	public Branch addExistingBranchToExistingAddress(int branchId,int addressId) {
		Branch branch=fetchBranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingBranchHead(int branchId,int branchHeadId) {
		Branch branch=fetchBranchById(branchId);
		BranchHead branchHead=branchHeadDao.fetchBranchHeadById(branchHeadId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingAmbulance(int branchId,int ambulanceId) {
		Branch branch=fetchBranchById(branchId);
		Ambulance ambulance=ambulanceDao.fetchAmbulanceById(ambulanceId);
		List<Ambulance> list=branch.getAmbulance();
		list.add(ambulance);
		branch.setAmbulance(list);
		return saveBranch(branch);
	}
	
	public Branch addNewAmbulanceToExistingBranch(int branchId,Ambulance newAmbulance) {
		Branch branch=fetchBranchById(branchId);
		List<Ambulance> list=branch.getAmbulance();
		list.add(newAmbulance);
		branch.setAmbulance(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingDoctor(int branchId,int doctorId) {
		Branch branch=fetchBranchById(branchId);
		Doctor doctor=doctorDao.fetchDoctorById(doctorId);
		List<Doctor> list=branch.getDoctor();
		list.add(doctor);
		branch.setDoctor(list);
		return saveBranch(branch);
	}
	
	public Branch addNewDoctorToExistingBranch(int branchId,Doctor newDoctor) {
		Branch branch=fetchBranchById(branchId);
		List<Doctor> list=branch.getDoctor();
		list.add(newDoctor);
		branch.setDoctor(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingPatient(int branchId,int patientId) {
		Branch branch=fetchBranchById(branchId);
		Patient patient=patientDao.fetchPatientById(patientId);
		List<Patient> list=branch.getPatient();
		list.add(patient);
		branch.setPatient(list);
		return saveBranch(branch);
	}
	
	public Branch addNewPatientToExistingBranch(int branchId,Patient newpPatient) {
		Branch branch=fetchBranchById(branchId);
		List<Patient> list=branch.getPatient();
		list.add(newpPatient);
		branch.setPatient(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingRoom(int branchId,int roomId) {
		Branch branch=fetchBranchById(branchId);
		Room room=roomDao.fetchRoomById(roomId);
		List<Room> list=branch.getRoom();
		list.add(room);
		branch.setRoom(list);
		return saveBranch(branch);
	}
	
	public Branch addNewRoomToExistingBranch(int branchId,Room newrRoom) {
		Branch branch=fetchBranchById(branchId);
		List<Room> list=branch.getRoom();
		list.add(newrRoom);
		branch.setRoom(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingEmployee(int branchId,int employeeId) {
		Branch branch=fetchBranchById(branchId);
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		List<Employee> list=branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
		Branch branch=fetchBranchById(branchId);
		List<Employee> list=branch.getEmployee();
		list.add(newEmployee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	

}
