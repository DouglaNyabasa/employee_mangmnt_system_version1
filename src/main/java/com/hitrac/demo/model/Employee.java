package com.hitrac.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

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
    private  String firstname;

    @Column(name = "second_name",nullable = false)
    private  String secondName;

    @Column(name = "dob",nullable = false)
    private  String dateOfBirth;

    @Column(name = "phone_number",nullable = false,unique = true)
    private  String phoneNumber;

   @Email(message = "{registration_email_is_not_valid}")
    @Column(name = "email",unique = true,nullable = false)
    private  String email;

    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Department department;


}
