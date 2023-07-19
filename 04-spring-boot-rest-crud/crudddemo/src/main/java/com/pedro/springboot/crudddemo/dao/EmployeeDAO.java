package com.pedro.springboot.crudddemo.dao;

import com.pedro.springboot.crudddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
