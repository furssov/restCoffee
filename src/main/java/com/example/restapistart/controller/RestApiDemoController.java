package com.example.restapistart.controller;

import com.example.restapistart.model.Coffee;
import com.example.restapistart.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/coffees")
@Slf4j
public class RestApiDemoController {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public RestApiDemoController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    public Iterable<Coffee> getAll()
    {
        return coffeeRepository.findAll();
    }

    @PostMapping()
    public Coffee postCoffee(@RequestBody Coffee coffee)
    {
        coffeeRepository.save(coffee);
        return coffee;
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffee(@PathVariable int id)
    {

        return coffeeRepository.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> changeCoffee(@PathVariable int id, @RequestBody Coffee coffee) {
        return (coffeeRepository.existsById(id))
                ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
                : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void  deleteCoffee(@PathVariable int id)
    {
        coffeeRepository.deleteById(id);
    }

}
