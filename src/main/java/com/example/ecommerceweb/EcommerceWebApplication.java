package com.example.ecommerceweb;

import com.example.ecommerceweb.models.Books;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EcommerceWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceWebApplication.class, args);
    }
}
