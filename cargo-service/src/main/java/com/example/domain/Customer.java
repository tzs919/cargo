package com.example.domain;

public class Customer {
    private Customer() {}

    private Long id;

    private String name;

    private String address;

    private String city;

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
