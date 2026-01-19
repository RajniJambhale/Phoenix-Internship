package com.example.phoenixcodecrafter.service;
import com.example.phoenixcodecrafter.model.Comment;


public interface CommentService {

    Comment addComment(Long postId, Long userId, String content);

}

