package com.example.ecommerceweb.converter;

import com.example.ecommerceweb.DTO.ImageDataDTO;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    @Autowired
    private ImageDataConverter imageDataConverter;

    public Users toEntity(UserDTO dto){
        Users entity = new Users();
        entity.setId(dto.getUserId());
        entity.setFullName(dto.getFullName());

//        entity.setAvatar(dto.getAvatar());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.isStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public Users toUpdateEntity(UserDTO dto,Users entity){
        entity.setFullName(dto.getFullName());

        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.isStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public UserDTO toDTO(Users entity){
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getId());
        dto.setFullName(entity.getFullName());

//        dto.setAvatar(entity.getAvatar());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.isStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public List<UserDTO> toListDTO(List<Users> list){
        List<UserDTO> listDTO = new ArrayList<UserDTO>();
        for (Users entity : list){
            listDTO.add(toDTO(entity));
        }
        return listDTO;
    }
}
