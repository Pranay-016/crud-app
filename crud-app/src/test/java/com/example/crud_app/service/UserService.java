package com.example.crud_app.service;

import com.example.crud_app.model.User;
import com.example.crud_app.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User addUser(User u) {
        return repo.save(u);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User updateUser(Long id, User newUser) {
        User existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(newUser.getName());
            existing.setEmail(newUser.getEmail());
            return repo.save(existing);
        }
        return null;
    }

    public String deleteUser(Long id) {
        repo.deleteById(id);
        return "User removed";
    }
}
