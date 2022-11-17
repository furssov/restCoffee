package com.example.restapistart.data;

import com.example.restapistart.model.Coffee;
import com.example.restapistart.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData()
    {
        coffeeRepository.save(new Coffee("Americano"));
        coffeeRepository.save(new Coffee("Americano milk"));
        coffeeRepository.save(new Coffee("Americano dark"));
    }
}
