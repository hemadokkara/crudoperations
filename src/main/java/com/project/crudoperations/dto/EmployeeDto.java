package com.project.crudoperations.dto;

import lombok.Data;

@Data
public class EmployeeDto {
 
    private Integer employeeId;
    private String employeeName;
    private String employeePhonenumber;
    private String employeeAddress;
    private EmploymentInformationDto employmentInfoDto;

}
