package com.companyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping("/companies")
	public List<Company> getCompanies() {
		return companyService.getCompanies();
		/*
		 * Uncomment this for Step1
		 * 
		 *  return Arrays.asList( new Company("Infosys",
		 * "Infosys India Pvt Ltd.", 100000), new Company("Oracle",
		 * "Oracle India Pvt Ltd.", 50000), new Company("MI",
		 * "MobileIron India Pvt Ltd.", 850) );
		 */

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/companies")
	public void addCompany(@RequestBody Company company) {
		companyService.addCompany(company);
	}
	
	@RequestMapping("/companies/{name}")
	public Optional<Company> getCompany(@PathVariable String name){
		System.out.println("Inside getCompany");
		return companyService.getCompany(name);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/companies/{name}")
	public void updateCompany(@RequestBody Company company, @PathVariable String name) {
		System.out.println("inside updateCompany");
		companyService.updateCompany(name, company);
	}


	@RequestMapping(method=RequestMethod.DELETE, value="/companies/{name}")
	public void deleteCompany(@PathVariable String name){
		System.out.println("Inside deleteCompany");
		companyService.deleteCompany(name);
	}
}
