package com.hitrac.demo.service;

import com.hitrac.demo.dto.DepartmentRequestDTO;
import com.hitrac.demo.model.Department;

import com.hitrac.demo.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ResponseEntity<Department> CreateDepartment(DepartmentRequestDTO departmentRequestDTO) {
        Department department = new Department();
        department.setDepartmentName(departmentRequestDTO.getDepartmentName());
        departmentRepository.save(department);
        return ResponseEntity.ok().body(department);
    }
}
