package com.project.crudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.crudoperations.entity.EmploymentInformation;

public interface EmployeeInfoRepo  extends JpaRepository<EmploymentInformation,Integer>{
    
}
