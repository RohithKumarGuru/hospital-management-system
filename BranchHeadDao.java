package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.exception.BranchHeadIdNotFound;
import com.project.hospital_management_system.repo.BranchHeadRepo;

@Repository
public class BranchHeadDao {
	@Autowired
	BranchHeadRepo branchHeadRepo;
	
	public BranchHead saveBranchHead(BranchHead branchHead) {
		return branchHeadRepo.save(branchHead);
	}
	
	public BranchHead fetchBranchHeadById(int branchHeadId) {
        Optional<BranchHead> optional = branchHeadRepo.findById(branchHeadId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new BranchHeadIdNotFound();
        }
    }
	
	public BranchHead deleteBranchHeadById(int branchHeadId) {
		BranchHead branchHead=fetchBranchHeadById(branchHeadId);
		branchHeadRepo.delete(branchHead);
		return branchHead;
	}
	
	public BranchHead updateBranchHeadById(int oldBranchHeadId,BranchHead newbBranchHead) {
		newbBranchHead.setBranchHeadId(oldBranchHeadId);
		return branchHeadRepo.save(newbBranchHead);
	}
	
	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadRepo.findAll();
	}

}
