
package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "cargo")
public class Cargo {
    @Id
    private Long id;

    @Column(name = "customer")
    private Long customer;

    @Column
    private String product;

    @Column
    private Integer quantity;

    @Transient
    private String name;

    @Transient
    private String address;

    @Transient
    private String city;

    @Transient
    private String email;

    private Cargo() {
    }

    public Cargo(Long id, Long customer, String product, Integer quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public String getProduct() {
        return this.product;
    }

    public Long getCustomer() {
        return this.customer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Cargo setProduct(String product) {
        this.product = product;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", customer_id=" + customer +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
