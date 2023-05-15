package com.hitrac.demo.service;

import com.hitrac.demo.dto.LeaveRequestDTO;
import org.springframework.http.ResponseEntity;

public interface LeaveService  {

     ResponseEntity applyLeave(LeaveRequestDTO leaveRequestDTO);



}
