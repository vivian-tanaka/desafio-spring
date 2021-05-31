package com.melidh.desafiospring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Seller{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "following")
    private Set<Customer> followers = new HashSet<>();

    @OneToMany(mappedBy = "seller")
    private List<Post> posts = new ArrayList<>();

    public Seller(){}

    public Seller(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
