package com.lucasantos.workshopmongo.dto;

import java.io.Serializable;

import com.lucasantos.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO(){
    }

    public AuthorDTO( User obj) { // instanciando um author apartir de um user
        id  = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}