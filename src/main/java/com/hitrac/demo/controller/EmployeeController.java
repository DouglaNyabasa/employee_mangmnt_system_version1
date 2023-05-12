package com.hitrac.demo.controller;

import com.hitrac.demo.dto.EmployeeRequest;
import com.hitrac.demo.dto.EmployeeResponse;
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
    public List<EmployeeResponse> getAllEmployee(){
       return employeeService.getAllEmployee();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void createEmployee(EmployeeRequest employeeRequest){
        employeeService.createEmployee(employeeRequest);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@PathVariable Long id,EmployeeRequest employeeRequest){
       return employeeService.updateEmployee(id, employeeRequest);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Response> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
