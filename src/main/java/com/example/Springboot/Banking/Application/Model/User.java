package com.example.Springboot.Banking.Application.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name is required")
    @Pattern(regexp = "^[a-zA-Z]*$" , message = "Name must contain only letters")
    private String name;

    @Length(min = 6 , message = "password must be 6 digits")
    private String password;


}
