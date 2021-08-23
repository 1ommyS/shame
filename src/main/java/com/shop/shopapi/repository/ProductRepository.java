package com.shop.shopapi.repository;

import com.shop.shopapi.entity.Customer;
import com.shop.shopapi.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product getProductById(Integer id);
    Product getProductByPrice(Float price);
    List<Product> getProductsByTitleContaining(String title);
}