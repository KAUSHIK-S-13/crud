package com.springdemo.EmpDetail.controller;

import com.springdemo.EmpDetail.model.Employee;
import com.springdemo.EmpDetail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> list(){
        return employeeService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Employee employee ){
        employeeService.save(employee);
        return "New employee Added";

    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id) {
        try {
            Employee employee = employeeService.get(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }


}
