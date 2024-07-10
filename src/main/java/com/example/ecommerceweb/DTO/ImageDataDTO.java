package com.example.ecommerceweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ImageDataDTO implements Serializable {
    private Long id;
    private String name;
    private String type;
}
