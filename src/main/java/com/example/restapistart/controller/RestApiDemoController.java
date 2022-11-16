package com.example.restapistart.controller;

import com.example.restapistart.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
@Slf4j
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController()
    {
        coffees.addAll(List.of(new Coffee(1, "Americano"), new Coffee(2, "Cappuccino")));
    }

    @GetMapping
    public List<Coffee> getAll()
    {
        return coffees;
    }

    @PostMapping()
    public Coffee postCoffee(@RequestBody Coffee coffee)
    {
        coffees.add(coffee);
        return coffee;
    }

    @GetMapping("/{id}")
    public Optional<Object> getCoffee(@PathVariable int id)
    {
        for(Coffee coffee : coffees)
        {
            if (coffee.getId() == id) return Optional.of(coffee);
        }
        return Optional.empty();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> changeCoffee(@PathVariable int id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;
        for (Coffee coffee1 : coffees)
        {
            if (coffee1.getId() == id)
            {
                coffeeIndex = coffees.indexOf(coffee);
                coffee1.setName(coffee.getName());
            }
        }
        return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) : new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void  deleteCoffee(@PathVariable int id)
    {
        coffees.removeIf(coffee -> coffee.getId() == id);
    }

}
