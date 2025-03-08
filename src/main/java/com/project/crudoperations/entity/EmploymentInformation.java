package com.project.crudoperations.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class EmploymentInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long eInfoId;
    private Float salary;
    private String departmentName;
    private Date hireDate;
    private String jobTitle; 
    @OneToOne(mappedBy = "employmentInfo")
    private Employee employee;
}
