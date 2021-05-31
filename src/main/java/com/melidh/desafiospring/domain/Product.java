package com.melidh.desafiospring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String type;
    private String brand;
    private String color;
    private Double price;
    private String notes;
    private Integer category;

    @OneToMany(mappedBy = "product")
    private List<Post> posts = new ArrayList<>();

    public Product(){}

    public Product(Integer id, String name, String type, String brand, String color, Double price, String notes, Integer category) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.notes = notes;
        this.category = category;
    }


}
