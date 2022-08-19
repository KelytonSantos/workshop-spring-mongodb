package com.lucasantos.workshopmongo.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasantos.workshopmongo.domain.Post;
import com.lucasantos.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    
    @Autowired
    public PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
       Optional<Post> obj = postService.findById(id);
       return ResponseEntity.ok().body(obj.get());
    }
}