package com.hitrac.demo.dto;

import com.hitrac.demo.model.Address;
import com.hitrac.demo.model.Department;
import com.hitrac.demo.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {

    private  Long id;
    private  String firstname;
    private  String secondName;
    private  String email;
    private Gender gender;
    private  String dateOfBirth;
    private  String phoneNumber;
    private Department department;
    private Address address;

}
