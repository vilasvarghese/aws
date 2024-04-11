package com.companyservice.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.companyservice.Company;
import com.companyservice.CompanyService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/companies/{companyName}/employees")
	public CompanyEmployees getEmployees(@PathVariable String companyName){
		CompanyEmployees compEmployees = new CompanyEmployees();
		compEmployees.setEmployeeList(employeeService.getAllEmployees(companyName));	
		return compEmployees;
	}
	
	@RequestMapping("/companies/{companyName}/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable String companyName, @PathVariable int id){
		Optional<Employee> optonalEmp = employeeService.getEmployee(id)	;
		return optonalEmp;
	}

	@RequestMapping(method=RequestMethod.POST, value="/companies/{companyName}/employees")
	public void createEmployee(@PathVariable String companyName, @RequestBody Employee emp){
		//Without this user would need to mention the company in the json while passing.
		//That can be confusing to the user..
		emp.setCompany(new Company(companyName, "",0));
		employeeService.createEmployee(emp);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/companies/{companyName}/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String companyName, @PathVariable String id) {
		System.out.println("inside updateEmployee");
		employee.setCompany(new Company(companyName, "",0));
		employeeService.updateEmployee(id, employee);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	public void deleteEmployee(@PathVariable int id){
		System.out.println("Inside deleteEmployee");
		employeeService.deleteEmployee(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/seedData")
	public void seedData(){
		companyService.addCompany(new Company("Hexaware", "Hexaware India Pvt Ltd", 22000));
		companyService.addCompany(new Company("Apple", "Apple India Pvt Ltd", 10000));
		companyService.addCompany(new Company("Infosys", "Infosys India Pvt Ltd", 5000));
		
		employeeService.createEmployee(new Employee(1, "Sajal from Hexaware", 1000000, "Hexaware"));
		employeeService.createEmployee(new Employee(2, "Sajal always from Hexaware", 2000000, "Hexaware"));
		employeeService.createEmployee(new Employee(3, "Sajal is also from Hexaware", 3000000, "Hexaware"));
		employeeService.createEmployee(new Employee(4, "Rehman pillar of Hexaware", 4000000, "Hexaware"));

		employeeService.createEmployee(new Employee(5, "Akash Shah", 40000, "Apple"));
		employeeService.createEmployee(new Employee(6, "Lakhvinder Singh", 1000, "Apple"));
		employeeService.createEmployee(new Employee(7, "Steve Jobs", 10, "Apple"));

		employeeService.createEmployee(new Employee(8, "Bill Gates", 1, "Infosys"));
		employeeService.createEmployee(new Employee(9, "Trump the president", 2, "Infosys"));
	}
}
