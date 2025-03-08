package com.project.crudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.crudoperations.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
