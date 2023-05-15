package com.hitrac.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "first_name",nullable = false)
    @NotBlank(message = "Every Employee must have a firstname !!!")
    private  String firstname;

    @Column(name = "second_name",nullable = false)
    @NotBlank(message = "Every Employee must have a secondName !!!")
    private  String secondName;

    @Column(name = "dob",nullable = false)
    @NotBlank(message = "Every Employee must have a dateOfBirth !!!")
    private  String dateOfBirth;

    @Column(name = "phone_number",nullable = false,unique = true)
    @NotBlank(message = "Every Employee must have a phoneNumber !!!")
    private  String phoneNumber;

    @Email(message = "registration_email_is_not_valid")
    @NotBlank(message = "Every Employee must have a email !!!")
    @Column(name = "email",unique = true,nullable = false)
    private  String email;

    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Every Employee must have a gender !!!")
    private Gender gender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department")
    @JoinTable(name = "EMPLOYEE_DEPARTMENT_TABLE",joinColumns ={
            @JoinColumn(name = "employee_id", referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "department_id",referencedColumnName = "id")
    })
    @NotBlank(message = "Every Employee must have a department !!!")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @JoinTable(name = "EMPLOYEE_ADDRESS_TABLE",joinColumns ={
            @JoinColumn(name = "employee_id", referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "address_id",referencedColumnName = "id")
    })
    @NotBlank(message = "Every Employee must have a address !!!")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYEE_SALARY_TABLE",joinColumns ={
            @JoinColumn(name = "employee_id", referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "salary_id",referencedColumnName = "id")
    })
    private Salary salary;

    @Enumerated(EnumType.STRING)
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYEE_LEAVE_TABLE",joinColumns ={
            @JoinColumn(name = "employee_id", referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "leave_id",referencedColumnName = "id")
    })
    private Leave leave;



}
