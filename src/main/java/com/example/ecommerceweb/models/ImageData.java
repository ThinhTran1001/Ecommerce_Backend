package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ImageData")
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
    private String type;

    @Lob
    @Column(name = "imagedata",columnDefinition = "LONGBLOB")
    private byte[] imageData;
}
