package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.models.ImageData;
import com.example.ecommerceweb.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserDTO extends AbstractDTO implements Serializable {

    private Long userId;
    private ImageDataDTO Avatar;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private boolean status;
    private Role role;
    private List<Books> booksCreated;
    private List<Books> booksUpdated;
}
