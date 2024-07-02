package com.example.ecommerceweb.mapper;

import com.example.ecommerceweb.DTO.ImageDataDTO;
import com.example.ecommerceweb.models.ImageData;
import org.mapstruct.Mapper;

@Mapper
public interface ImageDataMapper {

    ImageDataDTO toImageDataDto(ImageData imageData);

    ImageData toImageData(ImageDataDTO imageDataDTO);
}
