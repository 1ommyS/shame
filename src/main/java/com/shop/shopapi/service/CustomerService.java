package com.shop.shopapi.service;

import com.shop.shopapi.entity.Customer;
import com.shop.shopapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;


    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getCustomers() {
        return (List<Customer>) repository.findAll();
    }

    public void save(Customer customer) {
        repository.save(customer);
    }

    public void saveAllCustomers(List<Customer> customers) {
        repository.saveAll(customers);
    }

    public Customer findCustomerById(Integer id) {
        return repository.findCustomerById(id);
    }

    public void createCustomer(Customer customer) {
        Customer customerByName = repository.findCustomerByName(customer.getName());
        if (customerByName != null) {
            throw new IllegalStateException("customer with this name is already exists");
        }

        repository.save(customer);
    }

    public void updateCustomer(Customer customer, int id) throws IllegalStateException {
        Customer customerFromDB = repository.findCustomerById(id);
        if (customerFromDB == null) {
            throw new IllegalStateException("customer with this id doesn't exist");
        }
        customerFromDB.setName(customer.getName());
        customerFromDB.setAge(customer.getAge());
        customerFromDB.setBirthday(customer.getBirthday());
        customerFromDB.setVerified(customer.isVerified());
        repository.save(customerFromDB);

    }

    public void deleteCustomerById(int id) {
        if (repository.findCustomerById(id) == null)
            throw new IllegalStateException("Customer not found");
        repository.deleteById(id);
    }
}
