package com.example.ecommerceweb.mapper;


import com.example.ecommerceweb.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;

@Mapper
public interface UserMapper {
    UserDTO toUserDto(User user);

    User toUser(UserDTO userDTO);
}
