package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.models.ImageData;
import com.example.ecommerceweb.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class UserDTO extends AbstractDTO<UserDTO>{
    private Integer user_id;
    private ImageDataDTO Avatar;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private boolean status;
    private String address;
    private Role role;
    private Collection<Books> books_created;
    private Collection<Books> books_updated;
}
