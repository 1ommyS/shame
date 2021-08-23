package com.shop.shopapi.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToMany
    @JoinTable(
            name = "customer_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<com.shop.shopapi.entity.Customer> customers;

    public Product(String title, Float price, Integer amount, List<com.shop.shopapi.entity.Customer> customers) {
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", customers=" + customers +
                '}';
    }

    public Product() {

    }

    public List<com.shop.shopapi.entity.Customer> getCustomer() {
        return customers;
    }

    public void setCustomers(List<com.shop.shopapi.entity.Customer> customers) {
        this.customers = customers;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}