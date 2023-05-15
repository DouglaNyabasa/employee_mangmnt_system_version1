package com.hitrac.demo.service;


import com.hitrac.demo.dto.LoginRequestDTO;
import com.hitrac.demo.model.User;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<Response> register(User user);


    ResponseEntity<Response> login(LoginRequestDTO request);

}
