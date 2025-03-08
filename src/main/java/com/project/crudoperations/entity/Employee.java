package com.project.crudoperations.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    private String employeePhonenumber;
    private String employeeAddress;
    @OneToOne(cascade = CascadeType.ALL) // Cascade operations
    @JoinColumn(name = "employmentInfoId", referencedColumnName = "eInfoId") // Join column in Employee table
    private EmploymentInformation employmentInfo;
    
}
