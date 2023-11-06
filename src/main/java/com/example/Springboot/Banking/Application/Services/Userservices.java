package com.example.Springboot.Banking.Application.Services;

import com.example.Springboot.Banking.Application.Model.User;
import com.example.Springboot.Banking.Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userservices {

    @Autowired
    private UserRepository userRepository;

    public User adddata(User u) {
        return userRepository.save(u);
    }

    public List<User> getall() {
        return userRepository.findAll();
    }

    public Optional<User> gbyid(Long id) {
        return userRepository.findById(id);
    }

    public User gbyname(String name) {
        return userRepository.findByName(name);
    }
}
