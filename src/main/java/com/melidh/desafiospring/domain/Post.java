package com.melidh.desafiospring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melidh.desafiospring.domain.dto.PostRequestDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Post(){}

    public Post(Integer id, User user, Date date, Product product) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
