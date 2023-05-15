package com.hitrac.demo.dto;

import com.hitrac.demo.model.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveRequestDTO {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private Long EmployeeId;
    private LeaveType leaveType;
}
