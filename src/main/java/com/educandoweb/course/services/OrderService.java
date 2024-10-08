package com.educandoweb.course.services;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Resgistrar um Serviço na classe de Serviço OrderService como componente
@Service
public class OrderService {

    // Injeção de dependência
    @Autowired
    //Dependência com o Service
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
