package com.pedro.springboot.crudddemo.dao;

import com.pedro.springboot.crudddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);



}
