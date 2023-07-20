package com.pedro.springboot.crudddemo.dao;

import com.pedro.springboot.crudddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members") -> if we want to change from employees to members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
