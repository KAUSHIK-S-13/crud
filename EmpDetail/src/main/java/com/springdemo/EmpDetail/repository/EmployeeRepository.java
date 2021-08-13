package com.springdemo.EmpDetail.repository;


import com.springdemo.EmpDetail.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}