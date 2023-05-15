package com.hitrac.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Salary_table")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private BigDecimal Amount;
    private LocalDate dateProcessed;
    @Enumerated(EnumType.STRING)
    private Period period;
    private BigDecimal grossAmount;
    private BigDecimal deduction;
    private BigDecimal taxAmount;
    private BigDecimal netAmount;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Employee employee;

}
