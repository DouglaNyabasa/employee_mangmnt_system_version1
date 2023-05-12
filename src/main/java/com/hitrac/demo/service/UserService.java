package com.hitrac.demo.service;


import com.hitrac.demo.dto.LoginRequest;
import com.hitrac.demo.model.User;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<Response> register(User user);


    ResponseEntity<Response> login(LoginRequest request);

}
