package com.example.phoenixcodecrafter.repository;


import com.example.phoenixcodecrafter.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}


