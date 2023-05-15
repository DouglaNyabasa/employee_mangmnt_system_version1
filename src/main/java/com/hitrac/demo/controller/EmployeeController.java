package com.hitrac.demo.controller;

import com.hitrac.demo.dto.EmployeeRequestDTO;
import com.hitrac.demo.dto.EmployeeResponseDTO;
import com.hitrac.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponseDTO> getAllEmployee(){
       return employeeService.getAllEmployee();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        employeeService.createEmployee(employeeRequestDTO);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@PathVariable Long id, EmployeeRequestDTO employeeRequestDTO){
       return employeeService.updateEmployee(id, employeeRequestDTO);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Response> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
