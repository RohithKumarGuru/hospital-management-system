package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.exception.AddressIdNotFound;
import com.project.hospital_management_system.repo.AddressRepo;
@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	  public Address fetchAddressById(int addressId) {
	        Optional<Address> optional = addressRepo.findById(addressId);
	        if (optional.isPresent()) {
	            return optional.get();
	        } else {
	            throw new AddressIdNotFound();
	        }
	    }
	
	public Address deleteAddressById(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
	public Address updateAddressById(int oldAddressId,Address newAddress) {
		newAddress.setAddressId(oldAddressId);
		return addressRepo.save(newAddress);
	}
	
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}

}
