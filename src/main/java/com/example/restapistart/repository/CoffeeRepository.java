package com.example.restapistart.repository;

import com.example.restapistart.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Integer> {
}
