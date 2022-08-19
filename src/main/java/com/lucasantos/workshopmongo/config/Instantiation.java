package com.lucasantos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasantos.workshopmongo.domain.Post;
import com.lucasantos.workshopmongo.domain.User;
import com.lucasantos.workshopmongo.repository.PostRepository;
import com.lucasantos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Damasceno", "mzinho@gmail.com");
        User alex = new User(null, "Alex Mandado", "lek@gmail.com");
        User bob = new User(null, "Bob Marley", "bob@gmail.com" );

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "A cara do freio", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}