package com.example.phoenixcodecrafter.serviceImpl;

import com.example.phoenixcodecrafter.exception.UserNotFoundException;
import com.example.phoenixcodecrafter.model.User;
import com.example.phoenixcodecrafter.repository.UserRepository;
import com.example.phoenixcodecrafter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        List<User> user  = userRepository.findAll();
        if (user.isEmpty()) {
            throw new UserNotFoundException("No user found");
        }
        return user;
    }

    @Override
    public User getUserById(int Id) {
        return userRepository.findById(Id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + Id));

    }

    @Override
    public List<User> createUser(List<User> userdetail){
        List<User> users =userRepository.saveAll(userdetail);
        return users;
    }

    @Override
    public List<User> getUserByEmail(String email) {
        List<User> useremail = userRepository.findByEmail(email);
        return useremail;
    }

    @Override
    public User updateUserById(int id, User updateduser) {
        // Find existing user
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id));

        // Update fields
        existingUser.setUsername(updateduser.getUsername());
        existingUser.setEmail(updateduser.getEmail());

        // Save updated user
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }

}