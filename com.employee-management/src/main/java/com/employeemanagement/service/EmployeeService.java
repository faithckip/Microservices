package com.employeemanagement.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;

import com.employeemanagement.model.Employee;

@FeignClient
public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
