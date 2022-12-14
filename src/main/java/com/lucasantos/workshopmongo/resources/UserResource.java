package com.lucasantos.workshopmongo.resources;

import java.net.URI;
// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasantos.workshopmongo.domain.Post;
import com.lucasantos.workshopmongo.domain.User;
import com.lucasantos.workshopmongo.dto.UserDTO;
import com.lucasantos.workshopmongo.services.UserService;
// import com.lucasantos.workshopmongo.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    public UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){

        List<User> list= userService.findAll();

        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());//convertendo cada objeto da minha lista original para DTO
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
       Optional<User> obj = userService.findById(id);
       return ResponseEntity.ok().body(obj.get());
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        User obj = userService.fromDTO(objDto); //convers??o do dto para user
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        //linha acima eu indico um caminho do novo objeto criado

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
     }

     @PutMapping(value = "/{id}")
     public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
        User obj = userService.fromDTO(objDto);//
        obj.setId(id);
        obj = userService.update(obj);//atualizando
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
       Optional<User> obj = userService.findById(id);
       return ResponseEntity.ok().body(obj.get().getPosts());
    }
}