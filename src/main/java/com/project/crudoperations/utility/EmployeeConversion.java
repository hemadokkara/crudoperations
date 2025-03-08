package com.project.crudoperations.utility;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.project.crudoperations.dto.EmployeeDto;
import com.project.crudoperations.dto.EmploymentInformationDto;
import com.project.crudoperations.entity.Employee;
import com.project.crudoperations.entity.EmploymentInformation;

@Component
public class EmployeeConversion {

    public Employee convertToEmpEntity(EmployeeDto employeeDto){
        Employee employeeEntity = new Employee();
        employeeEntity.setEmployeeAddress(employeeDto.getEmployeeAddress());
        employeeEntity.setEmployeeId(employeeDto.getEmployeeId());
        employeeEntity.setEmployeeName(employeeDto.getEmployeeName());
        employeeEntity.setEmployeePhonenumber(employeeDto.getEmployeePhonenumber());
        // call EmploymentInfoEntity conversion
        employeeEntity.setEmploymentInfo(convertToEmploymentInformationEntity(employeeDto.getEmploymentInfoDto()));
        if(employeeDto.getEmployeeId()!=null){
            employeeEntity.setEmployeeId(employeeDto.getEmployeeId());
        }

        return employeeEntity;

    }


    public EmployeeDto convertToEmpDto(Employee employeeEntity){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeAddress(employeeEntity.getEmployeeAddress());
        employeeDto.setEmployeeId(employeeEntity.getEmployeeId());
        employeeDto.setEmployeeName(employeeEntity.getEmployeeName());
        employeeDto.setEmployeePhonenumber(employeeEntity.getEmployeePhonenumber());
        // call EmploymentInfo conversion
        employeeDto.setEmploymentInfoDto(convertToEmploymentInformationDto(employeeEntity.getEmploymentInfo()));
        if(employeeDto.getEmployeeId()!=null){
            employeeDto.setEmployeeId(employeeEntity.getEmployeeId());
        }

        return employeeDto;

    }

    public EmploymentInformation convertToEmploymentInformationEntity(EmploymentInformationDto eInfoDto){
            EmploymentInformation eInfoEntity = new EmploymentInformation();
            eInfoEntity.setDepartmentName(eInfoDto.getDepartmentName());
            eInfoEntity.setEInfoId(eInfoDto.getEInfoId());
            eInfoEntity.setHireDate(eInfoDto.getHireDate());
            eInfoEntity.setJobTitle(eInfoDto.getJobTitle());
            eInfoEntity.setSalary(eInfoDto.getSalary());
             
            return eInfoEntity;


    }

    public EmploymentInformationDto convertToEmploymentInformationDto(EmploymentInformation eInfoEntity){
        EmploymentInformationDto eInfoDto = new EmploymentInformationDto();
        eInfoDto.setDepartmentName(eInfoEntity.getDepartmentName());
        eInfoDto.setEInfoId(eInfoEntity.getEInfoId());
        eInfoDto.setHireDate(eInfoEntity.getHireDate());
        eInfoDto.setJobTitle(eInfoEntity.getJobTitle());
        eInfoDto.setSalary(eInfoEntity.getSalary());
         
        return eInfoDto;

    }


}
