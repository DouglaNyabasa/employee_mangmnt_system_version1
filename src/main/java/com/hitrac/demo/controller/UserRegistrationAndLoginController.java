package com.hitrac.demo.controller;

import com.hitrac.demo.dto.LoginRequestDTO;
import com.hitrac.demo.dto.RegistrationRequestDTO;
import com.hitrac.demo.model.User;
import com.hitrac.demo.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRegistrationAndLoginController {

    private final UserService userService;

    public UserRegistrationAndLoginController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<Response> register( @RequestBody User user, RegistrationRequestDTO registrationRequestDTO){
        return  userService.register(user);
    }
    @PostMapping("/login")
    public ResponseEntity<Response> login( @RequestBody LoginRequestDTO request){
        return  userService.login(request);
    }

}
