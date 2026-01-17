package com.example.phoenixcodecrafter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String username;

        @Email(message = "Enter valid email Id")
        @NotBlank(message = "Email should not blank")
        private String email;
}
