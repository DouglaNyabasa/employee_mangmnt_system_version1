package com.hitrac.demo.dto;

import com.hitrac.demo.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    private  String firstname;
    private  String secondName;
    @Email(message = "registration_email_is_not_valid")
    @NotBlank(message = "Every Employee must have a email !!!")
    private  String email;
    private Gender gender;
    private  String dateOfBirth;
    private  String phoneNumber;
    private int departmentId;
    private int addressId;


}
