package org.example.auth.service;

import org.example.auth.model.User;

import java.util.List;

public interface UserRegistrationService {
     void createUser(User user);
     User updateUser(User user);
     void deleteUser(Long id);
     User getUser(Long id);
     List<User> getAllUsers();
}
