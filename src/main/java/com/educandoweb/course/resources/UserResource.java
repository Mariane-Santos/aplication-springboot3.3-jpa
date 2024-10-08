package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //Injeção de dependência
    @Autowired
    private UserService service;

    // Responde uma requisição do tipo GET do Http é preciso usar a anotetion @GetMapping
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
       List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //EndPoint
    //(value = "/{id}") vai indicar que a requisição vai aceitar um ID dentro da Url
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
