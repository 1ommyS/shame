package com.shop.shopapi.repository;

import com.shop.shopapi.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
    Customer findCustomerByAge(Integer age);
    Customer findCustomerByName(String name);
    Customer findCustomerByBirthday(Date birthday);
    List<Customer> findCustomerByNameContaining(String name);
}