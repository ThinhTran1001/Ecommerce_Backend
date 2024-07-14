package com.example.ecommerceweb.DTO.request;

import com.example.ecommerceweb.DTO.ImageDataDTO;
import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestLoginDTO implements Serializable {

//    private ImageDataDTO Avatar;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private boolean status;
    private Role role;
}
