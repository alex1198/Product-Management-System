package com.alex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.entity.Product;

public interface EcommerceRepository extends JpaRepository<Product, Integer>{

}
