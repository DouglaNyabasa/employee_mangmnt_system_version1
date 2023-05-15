package com.hitrac.demo.service;


import com.hitrac.demo.dto.LeaveRequestDTO;
import com.hitrac.demo.model.Employee;
import com.hitrac.demo.model.Leave;
import com.hitrac.demo.model.LeaveStatus;
import com.hitrac.demo.repository.EmployeeRepository;
import com.hitrac.demo.repository.LeaveRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements  LeaveService{

    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository, EmployeeRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }
    public ResponseEntity applyLeave(LeaveRequestDTO leaveRequestDTO){
        Leave leave = new Leave();
        LeaveStatus leaveStatus = LeaveStatus.PENDING;
        Optional<Employee> employee = employeeRepository.findById(leaveRequestDTO.getEmployeeId());
        leave.setReason(leave.getReason());
        leave.setToDate(leaveRequestDTO.getToDate());
        leave.setFromDate(leaveRequestDTO.getFromDate());
        Period period = Period.between(leaveRequestDTO.getFromDate(),leaveRequestDTO.getToDate());
        leave.setDuration(period.getDays() + 1);
        leave.setEmployee(employee.get());
        leave.setLeaveStatus(leaveStatus);

        return ResponseEntity.ok().body(leaveRepository.save(leave));
    }
}
