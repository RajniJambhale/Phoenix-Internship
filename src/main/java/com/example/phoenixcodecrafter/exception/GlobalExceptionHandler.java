package com.example.phoenixcodecrafter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        // 404 - User not found
        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<Map<String, Object>> handleUserNotFound(
                UserNotFoundException ex) {

            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("message", ex.getMessage());
            response.put("timestamp", LocalDateTime.now());

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

}
