package com.melidh.desafiospring.domain.dto;

import com.melidh.desafiospring.domain.Post;

import java.text.SimpleDateFormat;

public class PostDTO {

    private Integer userId;
    private Integer id_post;
    private String date;
    private Detail detail;
    private Integer category;
    private Double price;
    private boolean hasPromo = false;
    private Double discount;

    public PostDTO(){}

    public PostDTO(Post post){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.userId = post.getUser().getId();
        this.id_post = post.getId();
        this.date = sdf.format(post.getDate());
        this.detail = new Detail(post.getProduct());
        this.category = post.getProduct().getCategory();
        this.price = post.getProduct().getPrice();
        this.hasPromo = post.isPromo();
        this.discount = post.getDiscount();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
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

    public boolean isPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
