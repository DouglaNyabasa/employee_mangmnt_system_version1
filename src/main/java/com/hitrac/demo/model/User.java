package com.hitrac.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Every User must have a name !!!")
	@Column(name = "username",unique = true ,nullable = false)
	private String username;

	@Column(name = "password",unique = true,nullable = false)
	private String password;

	@Email(message = "registration_email_is_not_valid")
	@Column(name = "email",unique = true ,nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "userRole" ,nullable = false)
	@JoinTable(name = "USER_ROLE_TABLE",joinColumns ={
			@JoinColumn(name = "user_id", referencedColumnName = "id")
	},inverseJoinColumns = {
			@JoinColumn(name = "role_id",referencedColumnName = "id")
	})
	private UserRole userRole;

}
