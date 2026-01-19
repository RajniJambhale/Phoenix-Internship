package com.example.phoenixcodecrafter.controller;
import com.example.phoenixcodecrafter.model.Comment;
import com.example.phoenixcodecrafter.model.CommentRequest;
import com.example.phoenixcodecrafter.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commets")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<Comment> addComment(
            @PathVariable Long postId,
            @RequestBody CommentRequest request) {

        Comment comment = commentService.addComment(
                postId,
                request.getUserId(),
                request.getContent()
        );

        return ResponseEntity.ok(comment);
    }
}
