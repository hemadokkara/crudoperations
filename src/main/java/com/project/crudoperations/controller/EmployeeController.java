package com.project.crudoperations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudoperations.dto.EmployeeDto;

import com.project.crudoperations.service.EmployeeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/employees")
public class EmployeeController {
     @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    //url:http://localhost:8080/employees/getEmployeeById/1
    @GetMapping("/getEmployeeById/{id}")
    public Optional<EmployeeDto> getEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.getEmployeeById(id);
    }
    //url: http://localhost:8080/employees/getId?id=1
    @GetMapping("/getId")
    public Integer getId(@RequestParam("id") Integer itemId) {
        return itemId;
    }


    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeDto updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee)==true?"Successful Updatiion":"Unsuccessful Update";
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") Integer id) {
        return employeeService.deleteEmployee(id) ? "Deleted Successfully" : "Employee Not Found";
    }
}

