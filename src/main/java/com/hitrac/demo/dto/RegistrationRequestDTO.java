package com.hitrac.demo.dto;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@ToString
@NoArgsConstructor
public class RegistrationRequestDTO {


	@Email(message = "registration_email_is_not_valid")
	@NotEmpty(message = "registration_email_not_empty")
	private String email;

	@NotEmpty(message = "registration_username_not_empty")
	private String username;

	@NotEmpty(message = "registration_password_not_empty")
	private String password;


}
