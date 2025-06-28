package com.project.hospital_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BranchHead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchHeadId;
	private String branchHeadName;
	private long branchHeadPhone;
	private String branchHeadEmail;
	private double branchHeadSalary;
	public int getBranchHeadId() {
		return branchHeadId;
	}
	public void setBranchHeadId(int branchHeadId) {
		this.branchHeadId = branchHeadId;
	}
	public String getBranchHeadName() {
		return branchHeadName;
	}
	public void setBranchHeadName(String branchHeadName) {
		this.branchHeadName = branchHeadName;
	}
	public long getBranchHeadPhone() {
		return branchHeadPhone;
	}
	public void setBranchHeadPhone(long branchHeadPhone) {
		this.branchHeadPhone = branchHeadPhone;
	}
	public String getBranchHeadEmail() {
		return branchHeadEmail;
	}
	public void setBranchHeadEmail(String branchHeadEmail) {
		this.branchHeadEmail = branchHeadEmail;
	}
	public double getBranchHeadSalary() {
		return branchHeadSalary;
	}
	public void setBranchHeadSalary(double branchHeadSalary) {
		this.branchHeadSalary = branchHeadSalary;
	}
	
	
	

}
