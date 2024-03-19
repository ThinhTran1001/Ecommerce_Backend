package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.AutheticationResponse;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.Service.Imlp.UserService;
import com.example.ecommerceweb.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<AutheticationResponse>  register(
            @RequestBody Users request
            ){
        return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping("login")
    public ResponseEntity<AutheticationResponse>  login(
            @RequestBody Users request
    ){
        return ResponseEntity.ok(userService.authenticate(request));
    }
}
