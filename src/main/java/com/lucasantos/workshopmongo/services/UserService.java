package com.lucasantos.workshopmongo.services;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasantos.workshopmongo.domain.User;
import com.lucasantos.workshopmongo.dto.UserDTO;
import com.lucasantos.workshopmongo.repository.UserRepository;
import com.lucasantos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    public UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public Optional<User> findById(String id) {
        Optional<User> user = repo.findById(id);
        if(!user.isPresent()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User insert(User obj){        
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

	public User update(User obj) {
		User newObj = findById(obj.getId()).orElse(new User());//objeto original do banco
		updateData(newObj, obj);
		return repo.save(newObj);
	}

    public void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

     public void updateData(User newObj, UserDTO obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        User user = new User(objDto.getId(), objDto.getName(), objDto.getEmail());
        return user;
    }
}