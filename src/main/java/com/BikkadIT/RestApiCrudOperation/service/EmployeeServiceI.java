package com.BikkadIT.RestApiCrudOperation.service;

import java.util.List;

import com.BikkadIT.RestApiCrudOperation.model.Employee;

public interface EmployeeServiceI {
	
	public boolean saveEmployee(Employee emp);
	
	public boolean saveAllEmployee (List<Employee>list);
	
	public abstract List<Employee>  getAllEmployee();
	
	public Employee getSingleEmployee(int emId);
	
	public Employee getSingleEmployeeQueryParam(int empId);
	
	public Employee getSingleEmployeePathParam(int empId);
	
	public Employee getSingleEmployeeuByReqBody(Employee emp);
	
	public void deletEmployee(int empId);
	
	public void deletAllEmployee(Employee tbl);
	
	
	
	
	
	
	
	

	

	


}
