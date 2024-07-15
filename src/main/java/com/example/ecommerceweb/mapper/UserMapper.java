package com.example.ecommerceweb.mapper;

import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.DTO.request.UserRequestLoginDTO;
import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.models.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRequestLoginDTO convertToUserRequestLoginDTO(Users user);
    Users convertToUser(UserRequestLoginDTO dto);
    Users convertToUser(UserDTO dto);
    UserDTO convertToUserDTO(Users user);
}
