package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.models.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
public class UserDTO extends AbstractDTO<UserDTO>{
    private Integer user_id;
    private String Avatar;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private boolean status;
    private String address;
    private Roles role_id;
    private Collection<Books> books_created;
    private Collection<Books> books_updated;


}
