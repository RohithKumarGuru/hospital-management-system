package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.BranchHeadDao;
import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.util.ResponseStructure;

@Service
public class BranchHeadService {
	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	ResponseStructure<BranchHead> responseStructure;
	
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully branchHead created in DB");
		responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.CREATED);
	}
	
    public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(int branchHeadId) {
        BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
        responseStructure.setStatusCode(HttpStatus.FOUND.value());
        responseStructure.setMessage("Successfully BranchHead fetched from DB");
        responseStructure.setData(branchHead);
        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
    }
	
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(int branchHeadId) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully branchHead deleted from DB");
		responseStructure.setData(branchHeadDao.deleteBranchHeadById(branchHeadId));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(int oldBranchHeadId,BranchHead newbBranchHead) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(oldBranchHeadId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully branchHead updated in DB");
		responseStructure.setData(branchHeadDao.updateBranchHeadById(oldBranchHeadId, newbBranchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
	
	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadDao.fetchAllBranchHead();
	}

}
