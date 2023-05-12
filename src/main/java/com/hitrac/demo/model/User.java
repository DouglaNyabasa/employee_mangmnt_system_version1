package com.hitrac.demo.model;

import lombok.*;

import javax.persistence.*;


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

	@Column(name = "username",unique = true ,nullable = false)
	private String username;

	@Column(name = "password",unique = true,nullable = false)
	private String password;

	@Column(name = "email",unique = true ,nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "userRole" ,nullable = false)
	private UserRole userRole;

}
