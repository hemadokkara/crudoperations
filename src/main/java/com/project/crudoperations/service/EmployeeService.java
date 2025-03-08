package com.project.crudoperations.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.crudoperations.dto.EmployeeDto;
import com.project.crudoperations.entity.Employee;
import com.project.crudoperations.repository.EmployeeRepo;
import com.project.crudoperations.utility.EmployeeConversion;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo  employeeRepository;

    @Autowired
    private EmployeeConversion employeeConversion;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return employeeConversion.convertToEmpDto(employeeRepository.save(employeeConversion.convertToEmpEntity(employeeDto)));
    }

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for(Employee employee:employeeList){
            employeeDtoList.add(employeeConversion.convertToEmpDto(employee));
        }
        
        return employeeDtoList;
    }

    public Optional<EmployeeDto> getEmployeeById(Integer id) {
        EmployeeDto employeeDto = employeeConversion.convertToEmpDto(employeeRepository.findById(id).get());
        Optional<EmployeeDto> employeeDtoOptional = Optional.of(employeeDto);
        return employeeDtoOptional;
    }

    public Boolean updateEmployee(Integer id, EmployeeDto updatedEmployeeDto) {

        

        return employeeRepository.findById(id).map(employee -> {
            employee.setEmployeeName(updatedEmployeeDto.getEmployeeName());
            employee.setEmployeePhonenumber(updatedEmployeeDto.getEmployeePhonenumber());
            employee.setEmployeeAddress(updatedEmployeeDto.getEmployeeAddress());
            employee.setEmploymentInfo(employeeConversion.convertToEmploymentInformationEntity(updatedEmployeeDto.getEmploymentInfoDto()));
            return employeeRepository.save(employee)!=null?true:false;
        }).orElse(false);
    }

    public boolean deleteEmployee(Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
