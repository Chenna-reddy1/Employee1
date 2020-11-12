package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EmpController {
 
	@Autowired
	private EmpRepo empRepo;
	
	@GetMapping("/Employees")
	public List<Employee> getemps(){
		return empRepo.findAll() ;
		
	}
	
	@GetMapping("/Employee/{id}")
	public Optional<Employee> getemp(@PathVariable("id") Long id)         
	{
		return empRepo.findById(id) ;
		
	}
	
	@PostMapping("/Employee")
	public Employee createemp(@RequestBody Employee employee) {
		return empRepo.save(employee);
		
	}
	
	@DeleteMapping("/Employee/{id}")
	public String Deletemp(@PathVariable("id") Long id) 
	{
		Employee e = empRepo.getOne(id);
		empRepo.deleteById(id);
		return "Deleted";
		
	}
	
	@PutMapping("/Employee")
	public Employee Updateemp(@RequestBody Employee employee)
	{
		return empRepo.save(employee) ;
		
	}
	
	
	
	

	
	
}
