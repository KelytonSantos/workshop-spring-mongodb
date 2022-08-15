package com.lucasantos.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasantos.workshopmongo.domain.User;
import com.lucasantos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();

        User maria = new User(null, "Maria Damasceno", "mzinho@gmail.com");
        User alex = new User(null, "Alex Mandado", "lek@gmail.com");
        User bob = new User(null, "Bob Marley", "bob@gmail.com" );

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}