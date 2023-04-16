package com.BikkadIT.RestApiCrudOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.RestApiCrudOperation.model.Employee;
import com.BikkadIT.RestApiCrudOperation.service.EmployeeServiceI;

import jakarta.websocket.server.PathParam;

@RestController
public class EmployeeController {

	@Autowired
	public EmployeeServiceI employeeServiceI;

	@PostMapping(value = "/saveEmployee", consumes = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {

		boolean saveEmployee = employeeServiceI.saveEmployee(emp);

		if (saveEmployee) {
			String msg = "Save Employee Successful";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			String msg = "Employee Not Save";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping(value = "/saveAllEmployee", consumes = "application/json")
	public ResponseEntity<String> saveAllEmployee(@RequestBody List<Employee> list) {

		boolean saveAllEmployee = employeeServiceI.saveAllEmployee(list);

		if (saveAllEmployee) {
			return new ResponseEntity<String>("All Employee Save Successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("All Employee Not Save", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {

		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		return allEmployee;

	}

	@GetMapping("/getEmployee/{empId}")
	public Employee getEmployee(@PathVariable int empId) {

		Employee singleEmployee = employeeServiceI.getSingleEmployee(empId);
		return singleEmployee;

	}

	@GetMapping(value = "/getEmpByIdQueryParam", produces = "application/json")
	public ResponseEntity<Employee> getEmpByIdQueryParam(@RequestParam int empId) {

		Employee emp = employeeServiceI.getSingleEmployeeQueryParam(empId);

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@GetMapping(value = "/getEmpByIdPathParam/{empId}", produces = "application/json")
	public ResponseEntity<Employee> getEmpByIdPathParam(@PathVariable int empId) {

		Employee emp = employeeServiceI.getSingleEmployeePathParam(empId);

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@GetMapping(value = "/getEmpByIdReqBody", produces = "application/json")
	public ResponseEntity<Employee> getEmpByIdReqBody(@RequestBody Employee emp) {

		Employee emp1 = employeeServiceI.getSingleEmployeeuByReqBody(emp);

		return new ResponseEntity<Employee>(emp1, HttpStatus.OK);

	}

	@DeleteMapping("/deletEmployee/{empId}")
	public ResponseEntity<HttpStatus> deletEmployee(@PathVariable int empId) {

		try {
			this.employeeServiceI.deletEmployee(empId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	@DeleteMapping("/deletEmployee")
	public void deletAllEmployee(@PathVariable Employee tbl) {
		
		
		
	}

}
