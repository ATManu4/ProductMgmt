package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.controller.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{
	
}
