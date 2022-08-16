package com.lucasantos.workshopmongo.resources;

// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasantos.workshopmongo.domain.User;
import com.lucasantos.workshopmongo.dto.UserDTO;
import com.lucasantos.workshopmongo.services.UserService;
import com.lucasantos.workshopmongo.services.exception.ObjectNotFoundException;

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
       if(!obj.isPresent()){
        throw new ObjectNotFoundException("Objeto não encontrado");
       }
       return ResponseEntity.ok().body(obj.get());
    }

}