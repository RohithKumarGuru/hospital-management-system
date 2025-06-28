package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Employee;
import com.project.hospital_management_system.exception.EmployeeIdNotFound;
import com.project.hospital_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee fetchEmployeeById(int employeeId) {
        Optional<Employee> optional = employeeRepo.findById(employeeId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EmployeeIdNotFound();
        }
    }
	
	public Employee deleteEmployeeById(int employeeId) {
		Employee employee=fetchEmployeeById(employeeId);
		employeeRepo.delete(employee);
		return employee;
	}
	
	public Employee updateEmployeeById(int oldEmployeeId,Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeRepo.save(newEmployee);
	}
	
	public List<Employee> fetchAllEmployee(){
		return employeeRepo.findAll();
	}

}
