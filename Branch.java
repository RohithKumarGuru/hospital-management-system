package com.project.hospital_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchGst;
	private long branchPhone;
	private String branchEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BranchHead branchHead;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ambulance> ambulance;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Doctor> doctor;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Patient> patient;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Room> room;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employee;
	
	public List<Ambulance> getAmbulance() {
		return ambulance;
	}
	public void setAmbulance(List<Ambulance> ambulance) {
		this.ambulance = ambulance;
	}
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public BranchHead getBranchHead() {
		return branchHead;
	}
	public void setBranchHead(BranchHead branchHead) {
		this.branchHead = branchHead;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchGst() {
		return branchGst;
	}
	public void setBranchGst(String branchGst) {
		this.branchGst = branchGst;
	}
	public long getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getBranchEmail() {
		return branchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}
	
	

}
