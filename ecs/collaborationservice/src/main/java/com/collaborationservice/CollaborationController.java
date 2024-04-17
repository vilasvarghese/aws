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
	public String getEmployeesRating(@PathVariable String companyName){
		/*CompanyEmployees compEmps = restTemplate.getForObject("http://localhost:8081/companies/"+companyName+"/employees", CompanyEmployees.class);
		List<Employee> empList = compEmps.getEmployeeList();
		List<EmployeeRatingCatalog> employeesRatingList = new ArrayList<EmployeeRatingCatalog>();
		for (Employee e : empList) {
			Rating r = restTemplate.getForObject("http://localhost:8082/ratings/employeerating/"+e.getId(), Rating.class);
			employeesRatingList.add(new EmployeeRatingCatalog(e, r));
		}
		return employeesRatingList;*/
		//http://rating:8082 can be found in the service Configuration and networking
		Rating r = restTemplate.getForObject("http://rating:8082/employeerating/1", Rating.class);
		return r.toString() +" Response from CollborationController";
	}

}
//curl http://172.17.0.3:8080/catalog/companies/Vilas - may return 500 server error 

