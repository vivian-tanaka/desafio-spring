package com.melidh.desafiospring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Post(){}

    public Post(Integer id, Seller seller, Date date, Product product) {
        this.id = id;
        this.seller = seller;
        this.date = date;
        this.product = product;
    }

}
