package com.springdemo.EmpDetail.DTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDTO {
    private int id;
    private String name;
    private String location;
}
