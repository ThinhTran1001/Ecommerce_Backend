package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.Service.IUserService;
import com.example.ecommerceweb.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserAPI {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/user")
    public UserDTO addUser(@RequestBody UserDTO model){
        return userService.AddUser(model);
    }

    @GetMapping(value = "/user")
    public List<Users> allUser(){
        return userService.FindAllUser();
    }

}
