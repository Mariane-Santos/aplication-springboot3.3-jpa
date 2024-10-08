package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

//Annotation para dizer que é uma classe de configuração
@Configuration
@Profile("test")
//vai rodar essa aplicação somente quando tiver no perfil de test
public class TestConfig implements CommandLineRunner {

    //@Autowired: é uma injeção de dependência
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        //Salvar os usuários no bonco de dados

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
