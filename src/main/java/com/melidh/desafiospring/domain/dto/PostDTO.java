package com.melidh.desafiospring.domain.dto;

import com.melidh.desafiospring.domain.Post;

import java.text.SimpleDateFormat;

public class PostDTO {

    private Integer user_id;
    private Integer post_id;
    private String date;
    private Detail detail;
    private Integer category;
    private Double price;

    public PostDTO(){}

    public PostDTO(Post post){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.user_id = post.getUser().getId();
        this.post_id = post.getId();
        this.date = sdf.format(post.getDate());
        this.detail = new Detail(post.getProduct());
        this.category = post.getProduct().getCategory();
        this.price = post.getProduct().getPrice();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
