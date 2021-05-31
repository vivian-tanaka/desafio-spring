package com.melidh.desafiospring.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Post(){}

    public Post(Integer id, Seller seller, LocalDate date, Product product) {
        this.id = id;
        this.seller = seller;
        this.date = date;
        this.product = product;
    }
}
