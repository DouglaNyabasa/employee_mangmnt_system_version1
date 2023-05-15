package com.hitrac.demo.service;

import com.hitrac.demo.dto.EmployeeRequestDTO;
import com.hitrac.demo.dto.EmployeeResponseDTO;
import com.hitrac.demo.model.Department;
import com.hitrac.demo.model.Employee;
import com.hitrac.demo.repository.DepartmentRepository;
import com.hitrac.demo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService  {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public EmployeeService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(EmployeeRequestDTO employeeRequestDTO){

       Optional<Department> department = departmentRepository.findById(Long.valueOf(employeeRequestDTO.getDepartmentId()));
       if (!department.isPresent()){
           throw new  NullPointerException("Department not found");
       }
        Employee employee = Employee.builder()
                .firstname(employeeRequestDTO.getFirstname())
                .secondName(employeeRequestDTO.getSecondName())
                .department(department.get())
                .dateOfBirth(employeeRequestDTO.getDateOfBirth())
                .gender(employeeRequestDTO.getGender())
                .phoneNumber(employeeRequestDTO.getPhoneNumber())
                .email(employeeRequestDTO.getEmail())
                .build();
        employeeRepository.save(employee);
    }

    public ResponseEntity deleteEmployee(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            employeeRepository.delete(employee.get());
            return ResponseEntity.ok().body("Employee deleted");
        }
        else
            return ResponseEntity.ok().body("Employee Not Found!!!");
    }

    public ResponseEntity updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            Employee employee1 = employee.get();
            employee1.setFirstname(employeeRequestDTO.getFirstname());
            employee1.setSecondName(employeeRequestDTO.getSecondName());
            employee1.setEmail(employeeRequestDTO.getSecondName());

            employeeRepository.save(employee1);
            return ResponseEntity.ok().body("Employee details has been updated");
        }
        else
            return ResponseEntity.ok().body("Employee Not Found");

    }

    public List<EmployeeResponseDTO> getAllEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapToEmployeeResponse).toList() ;
}
    private EmployeeResponseDTO mapToEmployeeResponse(Employee employee) {
        return EmployeeResponseDTO.builder()
                .id(employee.getId())
                .firstname(employee.getFirstname())
                .secondName(employee.getSecondName())
                .email(employee.getEmail())
                .build();
    }

    }
