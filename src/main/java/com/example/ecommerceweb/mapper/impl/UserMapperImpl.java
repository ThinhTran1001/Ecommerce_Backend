package com.example.ecommerceweb.mapper.impl;

import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.DTO.request.UserRequestLoginDTO;
import com.example.ecommerceweb.mapper.UserMapper;
import com.example.ecommerceweb.models.Users;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final ModelMapper modelMapper;

    @Override
    public UserRequestLoginDTO convertToUserRequestLoginDTO(Users user) {
        return modelMapper.map(user,UserRequestLoginDTO.class);
    }

    @Override
    public Users convertToUser(UserRequestLoginDTO dto) {
        return modelMapper.map(dto,Users.class);
    }

    @Override
    public Users convertToUser(UserDTO dto) {
        return modelMapper.map(dto,Users.class);
    }

    @Override
    public UserDTO convertToUserDTO(Users user) {
        return modelMapper.map(user,UserDTO.class);
    }
}
