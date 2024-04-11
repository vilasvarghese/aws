package com.collaborationservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CollaborationController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/catalog/companies/{companyName}")
	public List<EmployeeRatingCatalog> getEmployeesRating(@PathVariable String companyName){
		CompanyEmployees compEmps = restTemplate.getForObject("http://localhost:8081/companies/"+companyName+"/employees", CompanyEmployees.class);
		List<Employee> empList = compEmps.getEmployeeList();
		List<EmployeeRatingCatalog> employeesRatingList = new ArrayList<EmployeeRatingCatalog>();
		for (Employee e : empList) {
			Rating r = restTemplate.getForObject("http://localhost:8082/ratings/employeerating/"+e.getId(), Rating.class);
			employeesRatingList.add(new EmployeeRatingCatalog(e, r));
		}
		return employeesRatingList;
	}

}
