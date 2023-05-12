package com.hitrac.demo.service;

import com.hitrac.demo.dto.LoginRequest;
import com.hitrac.demo.model.User;
import com.hitrac.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity register(User user) {
        Optional<User> username = userRepository.findByUsername(user.getUsername());
        if(username.isPresent()){
            return ResponseEntity.ok().body("user already exists");
        }
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUserRole(user.getUserRole());
        User saved = userRepository.save(user1);
        return ResponseEntity.ok().body(saved);
    }

    @Override
    public ResponseEntity login(LoginRequest request) {
        request.getPassword();

        Optional<User> user = userRepository.findByUsername(request.getUsername());

       if(user.isPresent()){
           if(user.get().getPassword().equals(request.getPassword())){
               return  ResponseEntity.ok().body("log in successful");
           }
       }
       return  ResponseEntity.ok().body("wrong credentials ");
    }
}
