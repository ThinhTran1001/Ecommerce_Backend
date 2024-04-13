package com.example.ecommerceweb.converter;


import com.example.ecommerceweb.DTO.ImageDataDTO;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.models.ImageData;
import com.example.ecommerceweb.models.Users;
import org.springframework.stereotype.Component;

@Component
public class ImageDataConverter {
    public ImageDataDTO toDTO(ImageData entity){
        ImageDataDTO dto = new ImageDataDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        return dto;
    }

    public ImageData toEntity(ImageDataDTO dto){
        ImageData entity = new ImageData();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setImageData(new byte[0]);
        return entity;
    }
}
