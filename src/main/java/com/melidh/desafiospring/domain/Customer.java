package com.melidh.desafiospring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(name="CUSTOMER_SELLER",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "seller_id"))
    private Set<Seller> following = new HashSet<>();

    public Customer(){}

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
