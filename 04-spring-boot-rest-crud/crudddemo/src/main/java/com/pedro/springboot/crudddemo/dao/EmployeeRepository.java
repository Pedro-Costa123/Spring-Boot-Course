package com.pedro.springboot.crudddemo.dao;

import com.pedro.springboot.crudddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
