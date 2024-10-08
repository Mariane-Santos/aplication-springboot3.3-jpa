package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    //Injeção de dependência
    @Autowired
    private OrderService service;

    // Responde uma requisição do tipo GET do Http é preciso usar a anotetion @GetMapping
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
       List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //EndPoint
    //(value = "/{id}") vai indicar que a requisição vai aceitar um ID dentro da Url
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
