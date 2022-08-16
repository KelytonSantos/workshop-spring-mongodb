package com.lucasantos.workshopmongo.services;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasantos.workshopmongo.domain.User;
import com.lucasantos.workshopmongo.repository.UserRepository;
// import com.lucasantos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    public UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public Optional<User> findById(String id) {
        Optional<User> user = repo.findById(id);
        return user;
    }
}