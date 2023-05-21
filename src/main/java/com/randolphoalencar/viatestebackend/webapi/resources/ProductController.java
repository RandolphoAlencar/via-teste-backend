package com.randolphoalencar.viatestebackend.webapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.randolphoalencar.viatestebackend.webapi.entities.Product;

@RestController
@RequestMapping (value = "/products")
public class ProductController {
	
	@GetMapping
	public ResponseEntity<Product> findAll() {
		Product product = new Product(1, "Refrigerante", 6.99);
		return ResponseEntity.ok().body(product);
	}

}
