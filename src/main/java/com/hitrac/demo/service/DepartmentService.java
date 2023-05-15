package com.hitrac.demo.service;


import com.hitrac.demo.dto.DepartmentRequestDTO;
import com.hitrac.demo.model.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {

    ResponseEntity<Department> CreateDepartment(DepartmentRequestDTO departmentRequestDTO);



}
