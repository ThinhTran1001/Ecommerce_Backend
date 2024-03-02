package com.example.ecommerceweb.converter;

import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.models.Users;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public Users toEntity(UserDTO dto){
        Users entity = new Users();
        entity.setFullName(dto.getFullName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setStatus(dto.isStatus());
        entity.setAddress(dto.getAddress());
        entity.setBooks_created(dto.getBooks_created());
        entity.setBooks_updated(dto.getBooks_updated());
        return entity;
    }

    public UserDTO toDTO(Users entity){
        UserDTO dto = new UserDTO();
        dto.setFullName(entity.getFullName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setStatus(entity.isStatus());
        dto.setAddress(entity.getAddress());
        dto.setBooks_created(entity.getBooks_created());
        dto.setBooks_updated(entity.getBooks_updated());
        return dto;
    }
}
