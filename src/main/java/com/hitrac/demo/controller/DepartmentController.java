package com.hitrac.demo.controller;

import com.hitrac.demo.dto.DepartmentRequest;
import com.hitrac.demo.model.Department;
import com.hitrac.demo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Department> CreateDepartment (@RequestBody @Validated DepartmentRequest departmentRequestDTO){
        return  departmentService.CreateDepartment(departmentRequestDTO);
    }
}
