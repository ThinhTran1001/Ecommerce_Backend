package com.example.ecommerceweb.Service;

import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.models.Users;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public Long AddUser(UserDTO newUser);
    public void UpdateUser(Long userId,UserDTO newUser);
    public void DeleteUser(Long userId);
    public UserDTO FindOneUser(Long userId);
    public List<UserDTO> FindAllUser();

}
