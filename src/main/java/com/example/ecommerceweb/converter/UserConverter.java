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
        entity.setUser_id(dto.getUser_id());
        entity.setFullName(dto.getFullName());
        entity.setAvatar(imageDataConverter.toEntity(dto.getAvatar()));
//        entity.setAvatar(dto.getAvatar());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.isStatus());
        entity.setAddress(dto.getAddress());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setBooks_created(dto.getBooks_created());
        entity.setBooks_updated(dto.getBooks_updated());
        return entity;
    }

    public Users toUpdateEntity(UserDTO dto,Users entity){
        entity.setFullName(dto.getFullName());
        entity.setAvatar(imageDataConverter.toEntity(dto.getAvatar()));
//        entity.setAvatar(dto.getAvatar());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.isStatus());
        entity.setAddress(dto.getAddress());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setBooks_created(dto.getBooks_created());
        entity.setBooks_updated(dto.getBooks_updated());
        return entity;
    }

    public UserDTO toDTO(Users entity){
        UserDTO dto = new UserDTO();
        dto.setUser_id(entity.getUser_id());
        dto.setFullName(entity.getFullName());
        dto.setAvatar(imageDataConverter.toDTO(entity.getAvatar()));
//        dto.setAvatar(entity.getAvatar());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.isStatus());
        dto.setAddress(entity.getAddress());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setBooks_created(entity.getBooks_created());
        dto.setBooks_updated(entity.getBooks_updated());
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
