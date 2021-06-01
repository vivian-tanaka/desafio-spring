package com.melidh.desafiospring.domain.dto;

import com.melidh.desafiospring.domain.User;

public class BaseUserDTO {

    private Integer id;
    private String username;

    public BaseUserDTO(){

    }

    public BaseUserDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
