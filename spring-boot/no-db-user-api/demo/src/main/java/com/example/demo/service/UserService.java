package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(User user);
    List<User> getAllUser();
    User getUserById(String id);
    void deleteUser(String id);
    User updateUser(String id, User user);
}
