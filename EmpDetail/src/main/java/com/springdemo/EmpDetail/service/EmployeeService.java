package com.springdemo.EmpDetail.service;

import com.springdemo.EmpDetail.model.Employee;
import com.springdemo.EmpDetail.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee get(Integer id) {
        return employeeRepository.findById(id).get();
    }
}
