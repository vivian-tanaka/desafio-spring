package com.melidh.desafiospring.domain.dto;

import com.melidh.desafiospring.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserFollowingDTO extends BaseUserDTO{

    private List<BaseUserDTO> following = new ArrayList<>();

    public UserFollowingDTO(){}

    public UserFollowingDTO(User user){
        super(user);
    }

    public List<BaseUserDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<BaseUserDTO> following) {
        this.following = following;
    }
}
