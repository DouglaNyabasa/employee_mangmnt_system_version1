package com.hitrac.demo.controller;

import com.hitrac.demo.dto.LeaveRequestDTO;
import com.hitrac.demo.service.LeaveServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/leave")
public class LeaveController {

    private final LeaveServiceImpl leaveServiceImpl;

    public LeaveController(LeaveServiceImpl leaveServiceImpl) {
        this.leaveServiceImpl = leaveServiceImpl;
    }


    @PostMapping("apply")
    public ResponseEntity applyLeave(@RequestBody LeaveRequestDTO leaveRequestDTO){

        return leaveServiceImpl.applyLeave(leaveRequestDTO);
    }


}
