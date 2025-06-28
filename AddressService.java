package com.project.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system.dao.AddressDao;
import com.project.hospital_management_system.dto.Address;
import com.project.hospital_management_system.dto.Owner;
import com.project.hospital_management_system.exception.AddressIdNotFound;
import com.project.hospital_management_system.exception.OwnerIdNotFound;
import com.project.hospital_management_system.util.ResponseStructure;
@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully Address created in db");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}
	
	 public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
	        Address address = addressDao.fetchAddressById(addressId);
	        responseStructure.setStatusCode(HttpStatus.FOUND.value());
	        responseStructure.setMessage("Successfully address fetched from DB");
	        responseStructure.setData(address);
	        return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
	    }
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully address deleted from DB");
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId,Address newAddress) {
		Address address = addressDao.fetchAddressById(oldAddressId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully address updated in DB");
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Address> fetchAllAddress() {
		return addressDao.fetchAllAddress();
	}

}