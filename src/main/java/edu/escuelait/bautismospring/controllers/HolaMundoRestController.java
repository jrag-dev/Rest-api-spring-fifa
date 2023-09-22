package edu.escuelait.bautismospring.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRestController {

    @GetMapping("/saludo/{usuario}")
    public String saludo(@PathVariable String usuario) {
        return "Hola mundo Spring Boot " + usuario;
    }

    @GetMapping("/sumar/{numeroA}/{numeroB}")
    public int suma(@PathVariable int numeroA, @PathVariable int numeroB) {
        int total = numeroA + numeroB;
        return total;
    }
}
