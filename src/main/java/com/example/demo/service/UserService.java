package com.example.demo.service;

import com.example.demo.dto.UserPatchDTO;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(User user);

    List<User> getAllUser();

    User getUserById(String id);

    void deleteUser(String id);

    User updateUser(String id, User user);

    User patchUser(String id, UserPatchDTO userPatchDTO);
}