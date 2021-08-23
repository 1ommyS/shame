package com.shop.shopapi;

import com.github.javafaker.Faker;
import com.shop.shopapi.entity.Customer;
import com.shop.shopapi.repository.CustomerRepository;
import com.shop.shopapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ShopApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApiApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository customerRepository,
            ProductRepository productRepository
    ) {
        return args -> {
            Faker faker = new Faker();

            String name = faker.name().fullName();
            Integer age = faker.number().numberBetween(1, 100);
            Date birthday = faker.date().birthday();

            Customer customer = new Customer(
                    age,
                    name,
                    birthday,
                    true,
                    null
            );
            customerRepository.save(customer);
        };
    }
}
