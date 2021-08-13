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
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmplopyee(@PathVariable int id) {
        return employeeService.deleteEmplopyee(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable Integer id){
        try{
            Employee existingEmployee=employeeService.getEmployeeById(id);
            employeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

   /* @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return EmployeeService.updateEmployee(employee);
    }
*/
}
