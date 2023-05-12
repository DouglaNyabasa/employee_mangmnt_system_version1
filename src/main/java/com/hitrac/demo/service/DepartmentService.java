package com.hitrac.demo.service;


import com.hitrac.demo.dto.DepartmentRequest;
import com.hitrac.demo.model.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface DepartmentService {

    ResponseEntity<Department> CreateDepartment(DepartmentRequest departmentRequest);



}
