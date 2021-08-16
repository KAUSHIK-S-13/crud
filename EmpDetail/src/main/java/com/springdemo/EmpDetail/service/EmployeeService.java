package com.springdemo.EmpDetail.service;

import com.springdemo.EmpDetail.BaseResponse.BaseResponse;
import com.springdemo.EmpDetail.DTO.EmployeeDTO;
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

    public BaseResponse addetail(EmployeeDTO employeeDTO)
    {
        Employee dto=new Employee();
        BaseResponse baseResponse=new BaseResponse();
        dto.setName(employeeDTO.getName());
        dto.setLocation(employeeDTO.getLocation());
        employeeRepository.save(dto);
        baseResponse.setData(dto);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        return  baseResponse;
    }

    public BaseResponse deletedetail(int id) {
        BaseResponse baseResponse = new BaseResponse();
        employeeRepository.deleteById(id);
        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Employee deleted successfully");
        return baseResponse;
    }

    public Employee getEmployeeById(int id) {


        return employeeRepository.findById(id).orElse(null);
    }

    public BaseResponse updatedetail(EmployeeDTO employeeDTO) {

        BaseResponse baseResponse = new BaseResponse();
        Employee existemployee = employeeRepository.findById(employeeDTO.getId()).orElse(null);
        existemployee.setId(employeeDTO.getId());
        existemployee.setName(employeeDTO.getName());
        existemployee.setLocation(employeeDTO.getLocation());
        employeeRepository.save(existemployee);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("employee updated successfully");
        baseResponse.setData(existemployee);
        return baseResponse;
    }


}
