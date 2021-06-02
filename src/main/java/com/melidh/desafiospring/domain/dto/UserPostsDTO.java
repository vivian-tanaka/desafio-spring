package com.melidh.desafiospring.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class UserPostsDTO {

    private Integer userId;
    private List<PostDTO> posts = new ArrayList<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
