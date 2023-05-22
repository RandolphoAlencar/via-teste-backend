package com.randolphoalencar.viatestebackend.webapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.randolphoalencar.viatestebackend.webapi.entities.Product;
import com.randolphoalencar.viatestebackend.webapi.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Integer id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		product = productRepository.save(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
		
		Optional<Product> oldProduct = productRepository.findById(id);
		if (oldProduct.isPresent()) {
			Product obj = oldProduct.get();
			obj.setName(product.getName());
			obj.setOrderStatus(product.getOrderStatus());
			productRepository.save(obj);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Integer id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(product.get().getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}