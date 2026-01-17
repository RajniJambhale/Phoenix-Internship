package com.example.phoenixcodecrafter.repository;

import com.example.phoenixcodecrafter.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface PostRepository extends JpaRepository<Post, Serializable> {

}