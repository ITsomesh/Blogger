package com.BikkadIT.RestApiCrudOperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.BikkadIT.RestApiCrudOperation.dao.EmployeeRepository;
import com.BikkadIT.RestApiCrudOperation.model.Employee;

@Service
public class EmployeeServiceIMpl implements EmployeeServiceI {

	
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public boolean saveEmployee(Employee emp) {

		Employee employee = employeeRepository.save(emp);

		if (employee != null) {
			return true;
		} else {

			return false;
		}
	}

	@Override
	public boolean saveAllEmployee(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll(list);
		
		if(saveAll!=null) {
			return true;
		}else {
		return false;
	}

		
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

	@Override
	public Employee getSingleEmployee(int emId) {

		Employee emp = employeeRepository.findById(emId).get();
		if (emp !=null) {
			String msg="User Not Found";
			
		}
		return emp;
	}

	@Override
	public Employee getSingleEmployeeQueryParam(int empId) {
		
		Employee emp = employeeRepository.findById(empId).get();
		
		return emp;
	}

	@Override
	public Employee getSingleEmployeePathParam(int empId) {
		
		Employee emp = employeeRepository.findById(empId).get();
		
		return emp;
	}

	@Override
	public Employee getSingleEmployeeuByReqBody(Employee emp) {

		
		int empId = emp.getEmpId();
		Employee emp1 = employeeRepository.findById(empId).get();
		
		return emp1;
	}

	@Override
	public void deletEmployee(int empId) {
		
		Employee one = employeeRepository.getOne(empId);
		employeeRepository.delete(one);
		
	}

	@Override
	public void deletAllEmployee(Employee tbl) {
		employeeRepository.delete(tbl);
		
		
	}

	

	

	

	
	
	
	

	

	

	

	




	
	

}
