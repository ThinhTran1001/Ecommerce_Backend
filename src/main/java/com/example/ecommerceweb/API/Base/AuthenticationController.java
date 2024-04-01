package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.AutheticationResponse;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.Service.Imlp.UserService;
import com.example.ecommerceweb.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @PostMapping("login")
    public ResponseEntity<AutheticationResponse>  login(
            @RequestBody Users request
    ){
        return ResponseEntity.ok(userService.authenticate(request));
    }
}
