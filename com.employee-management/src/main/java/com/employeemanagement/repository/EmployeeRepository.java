package com.employeemanagement.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employeemanagement.model.Employee;

@Repository
@FeignClient
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
