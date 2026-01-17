package com.example.phoenixcodecrafter.service;

import com.example.phoenixcodecrafter.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(int Id);
    List<User> createUser(List<User> user);


}
