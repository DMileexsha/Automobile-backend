package com.mileesha.automobile_backend.Controller;

import com.mileesha.automobile_backend.Model.User;
import com.mileesha.automobile_backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

public class UserController {

    @Autowired
    private UserRepo userRepo;


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(User user) {

        //email checking
        Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Email Registered!");
        }

        User savedUser = userRepo.save((user));
        return ResponseEntity.ok("User Registered Successfully with id:" + savedUser.getId());
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(User loginData) {
        Optional<User> userOpt = userRepo.findByEmail(loginData.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (user.getPassword().equals(loginData.getPassword())) {
                return ResponseEntity.ok("Sign in Successful, Welcome" + user.getFirstName());

            } else {
                return ResponseEntity.status(401).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(404).body("User Not Found");
        }
    }

}
