package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	List<Employee>employees;
	
	public EmployeeController(){
		this.employees = new ArrayList<Employee>();
		this.employees.add(new Employee("1","John","male"));
		this.employees.add(new Employee("2","Jane","female"));
	}
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployee(@RequestParam(value = "gender", defaultValue = "male") String gender) {
		return this.employees.stream().filter(s -> s.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
		//return null;
	}

	@RequestMapping(value = "/employee2", method = RequestMethod.POST)
	@ResponseBody
	public Employee getEmployee2(@RequestBody Employee emp) {
		this.employees.add(emp);
		return emp;
	}
	@RequestMapping(value = "/employee3/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployee3(@PathVariable String id) {
		Employee emp = this.employees.stream().filter(s->s.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
		if(emp==null){
			throw new EmployeeNotFoundException();
		}
		else{
			return emp;
		}
		
	}
}
