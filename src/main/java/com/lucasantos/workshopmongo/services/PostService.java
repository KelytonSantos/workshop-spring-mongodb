package com.lucasantos.workshopmongo.services;

import java.util.Date;
import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasantos.workshopmongo.domain.Post;
import com.lucasantos.workshopmongo.repository.PostRepository;
import com.lucasantos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    public PostRepository repo;

    public Optional<Post> findById(String id) {
        Optional<Post> user = repo.findById(id);
        if(!user.isPresent()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearche(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}