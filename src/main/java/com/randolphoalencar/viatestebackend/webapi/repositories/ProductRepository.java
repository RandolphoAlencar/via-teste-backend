package com.randolphoalencar.viatestebackend.webapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randolphoalencar.viatestebackend.webapi.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
