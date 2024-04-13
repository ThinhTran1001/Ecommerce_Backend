package com.example.ecommerceweb.Service;

import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.models.Users;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public UserDTO AddUser(UserDTO newUser);
    public UserDTO UpdateUser(UserDTO newUser);
    public UserDTO DeleteUser(UserDTO newUser);
    public UserDTO FindOneUser(UserDTO newUser);
    public List<UserDTO> FindAllUser();

}
