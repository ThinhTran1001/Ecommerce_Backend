package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.DTO.response.ResponseData;
import com.example.ecommerceweb.DTO.response.ResponseError;
import com.example.ecommerceweb.Service.IUserService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/user")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "")
    public ResponseData<Long> addUser(@RequestBody UserDTO model){
        log.info("Request add user, {} {}", model.getEmail(), model.getUsername());

        try {
            long userId = userService.AddUser(model);
            return new ResponseData<>(HttpStatus.CREATED.value(), "user.add.success", userId);
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user fail");
        }
    }

    @PutMapping(value = "/{id}")
    public void updateUser(@RequestBody UserDTO model, @PathVariable("id") Long id){
        log.info("Update User");
        userService.UpdateUser(id, model);
    }

    @GetMapping(value = "/{id}")
    public UserDTO getOneUser(@PathVariable("id") Long id){
        log.info("Get User by id = {}", id);
        return userService.FindOneUser(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        log.info("Request delete user");
        userService.DeleteUser(id);
    }

    @GetMapping("")
    public List<UserDTO> getAll(){
        return userService.FindAllUser();
    }
}
