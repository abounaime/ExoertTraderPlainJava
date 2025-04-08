package org.example.auth.service;

import org.example.auth.model.User;

import java.util.List;

public interface UserRegistrationService {
    public void createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long id);
    public User getUser(Long id);
    public List<User> getAllUsers();
}
