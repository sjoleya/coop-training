package com.example.demo.service.impl;

import com.example.demo.dto.UserPatchDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import java.util.*;

import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(String id) {
        User user = userMap.get(id);
        if (user == null) {
            throw new ResourceNotFoundException("user not found with ID: " + id);
        }
        return user;
    }

    @Override
    public void deleteUser(String id) {
        if (!userMap.containsKey(id)) {
            throw new ResourceNotFoundException("user not found with ID: " + id);
        }
        userMap.remove(id);
    }

    @Override
    public User updateUser(String id, User user) {
        if (!userMap.containsKey(id)) {
            throw new ResourceNotFoundException("user not found with ID: " + id);
        }
        if(user.getId() == null) {
            user.setId(id);
        }
        userMap.put(id, user);
        return user;
    }

    @Override
    public User patchUser(String id, UserPatchDTO user) {
        User existingUser = getUserById(id);
        if (user.getName() != null && !user.getName().trim().isEmpty()) {
            existingUser.setName(user.getName());
        }
        if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
            existingUser.setPassword(user.getPassword());
        }
        return save(existingUser);
    }
}
