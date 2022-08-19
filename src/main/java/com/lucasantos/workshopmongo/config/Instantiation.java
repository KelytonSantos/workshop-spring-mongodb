package com.lucasantos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasantos.workshopmongo.domain.Post;
import com.lucasantos.workshopmongo.domain.User;
import com.lucasantos.workshopmongo.dto.AuthorDTO;
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

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "A cara do freio", new AuthorDTO(maria));//eu crio um autor(não é referencia) com nome(que veio do usuario) e id.(ver mais em dto)

        
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}