package com.hitrac.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Leave_table")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  LeaveType leaveType;
    @NotNull(message = "Please provide start date!")
    private LocalDate fromDate;
    @NotNull(message = "Please provide end date!")
    private LocalDate toDate;
    @ManyToOne
    private Employee employee;
    @NotEmpty(message = "Please provide a reason for the leave!")
    private String reason;
    private int duration;
    private LeaveStatus leaveStatus ;




}
