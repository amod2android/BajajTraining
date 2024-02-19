package com.bajaj.jwtdemo.contollers;

import com.bajaj.jwtdemo.models.AuthRequest;
import com.bajaj.jwtdemo.models.User;
import com.bajaj.jwtdemo.services.JwtService;
import com.bajaj.jwtdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/{username}")
    public String get() {
        return "";
    }

    @PostMapping("/register")
    public ResponseEntity<Object> create(@RequestBody User user) {
        User createUser = userService.create(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Create");
        response.put("data", createUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            return "Something wrong";
        }

    }

    @GetMapping("/protected")
    public String fetch() {
        return "something";
    }

}
