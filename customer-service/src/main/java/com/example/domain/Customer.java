package com.example.domain;

import javax.persistence.*;

@Entity(name = "customer")
public class Customer {
    private Customer() {}

    @Id
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="email")
    private String email;

    public Customer(Long id, String name, String address, String city,
                    String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    //用于测试获取属性
    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
