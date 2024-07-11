package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String type;

    @Lob
    @Column(name = "img_data",columnDefinition = "LONGBLOB")
    private byte[] imageData;
}
