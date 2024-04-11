package com.companyservice.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAORepository employeeDAORepository;
	
	public List<Employee> getAllEmployees(String companyName){
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeDAORepository.findByCompanyName(companyName).forEach(employeeList::add);
		return employeeList;
	}

	
	public Optional<Employee> getEmployee(int id) {
		return employeeDAORepository.findById(id);
	}
	
	public void createEmployee(Employee employee) {
		employeeDAORepository.save(employee);
	}
	
	public void updateEmployee(String id, Employee employee) {
		employeeDAORepository.save(employee);
	}
	
	public void deleteEmployee(int id) {
		employeeDAORepository.deleteById(id);
	}
}