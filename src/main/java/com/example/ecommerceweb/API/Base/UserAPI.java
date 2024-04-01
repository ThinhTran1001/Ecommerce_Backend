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

    @PutMapping(value = "/user/{id}")
    public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") Integer id){
        model.setUser_id(id);
        return userService.UpdateUser(model);
    }

    @GetMapping(value = "/user")
    public List<UserDTO> allUser(){
        return userService.FindAllUser();
    }

    @GetMapping(value = "/user/{id}")
    public UserDTO getOneUser(@RequestBody UserDTO model,@PathVariable("id") Integer id){
        model.setUser_id(id);
        return userService.FindOneUser(model);
    }
    @DeleteMapping(value = "/user/{id}")
    public UserDTO deleteUser(@RequestBody UserDTO model,@PathVariable("id") Integer id){
        model.setUser_id(id);
        return userService.DeleteUser(model);
    }

}
