package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.Service.IUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserAPI {

    @Autowired
    private IUserService userService;



    @PostMapping(value = "")
    public UserDTO addUser(@RequestBody UserDTO model){
        return userService.AddUser(model);
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") Long id){
        model.setUserId(id);
        return userService.UpdateUser(model);
    }


    @GetMapping(value = "/{id}")
    public UserDTO getOneUser(@RequestBody UserDTO model,@PathVariable("id") Long id){
        model.setUserId(id);
        return userService.FindOneUser(model);
    }
    @DeleteMapping(value = "/{id}")
    public UserDTO deleteUser(@RequestBody UserDTO model,@PathVariable("id") Long id){
        model.setUserId(id);
        return userService.DeleteUser(model);
    }


}
