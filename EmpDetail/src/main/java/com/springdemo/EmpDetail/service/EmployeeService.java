package com.springdemo.EmpDetail.service;

import com.springdemo.EmpDetail.BaseResponse.BaseResponse;
import com.springdemo.EmpDetail.DTO.EmployeeDTO;
import com.springdemo.EmpDetail.Exception.ResourseNotFoundException;
import com.springdemo.EmpDetail.model.Employee;
import com.springdemo.EmpDetail.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        baseResponse.setStatusMsg("sucess");
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

    public BaseResponse deleted(){
        BaseResponse baseResponse = new BaseResponse();
        employeeRepository.deleteAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("employee info deleted successfully..");
        return baseResponse;
    }

        public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("not found"));
        }

        public BaseResponse updatedetail(EmployeeDTO employeeDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Employee> existemployee = employeeRepository.findById(employeeDTO.getId());
        if(existemployee.isPresent()){
            existemployee.get().setId(employeeDTO.getId());
            existemployee.get().setName(employeeDTO.getName());
            existemployee.get().setLocation(employeeDTO.getLocation());
            employeeRepository.save(existemployee.get());}
        else
        {
            throw new RuntimeException("data not found");
        }
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("employee updated successfully");
        baseResponse.setData(existemployee);
        return baseResponse;
    }


}
