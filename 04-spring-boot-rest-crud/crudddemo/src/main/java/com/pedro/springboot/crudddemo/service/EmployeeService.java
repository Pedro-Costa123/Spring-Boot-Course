package com.pedro.springboot.crudddemo.service;

import com.pedro.springboot.crudddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
