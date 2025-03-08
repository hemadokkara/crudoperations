package com.project.crudoperations.dto;

import java.util.Date;

import com.project.crudoperations.entity.Employee;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class EmploymentInformationDto {
    
    private Long eInfoId;
    private Float salary;
    private String departmentName;
    private Date hireDate;
    private String jobTitle; 
    private Employee employee;
}
