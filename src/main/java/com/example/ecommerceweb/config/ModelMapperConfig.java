package com.example.ecommerceweb.config;

import com.example.ecommerceweb.DTO.request.UserRequestLoginDTO;
import com.example.ecommerceweb.models.Users;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        return new ModelMapper();
    }
}
