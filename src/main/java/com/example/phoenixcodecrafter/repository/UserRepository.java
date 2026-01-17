package com.example.phoenixcodecrafter.repository;

import com.example.phoenixcodecrafter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


    @Repository
    public interface UserRepository extends JpaRepository<User, Serializable> {
}
