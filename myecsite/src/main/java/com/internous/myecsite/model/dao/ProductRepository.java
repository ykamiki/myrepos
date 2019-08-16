package com.internous.myecsite.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internous.myecsite.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
