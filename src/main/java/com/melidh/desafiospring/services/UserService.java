package com.melidh.desafiospring.services;

import com.melidh.desafiospring.domain.Post;
import com.melidh.desafiospring.domain.User;
import com.melidh.desafiospring.domain.dto.BaseUserDTO;
import com.melidh.desafiospring.domain.dto.UserFollowCountDTO;
import com.melidh.desafiospring.domain.dto.UserFollowersDTO;
import com.melidh.desafiospring.domain.dto.UserFollowingDTO;
import com.melidh.desafiospring.repositories.UserRepository;
import com.melidh.desafiospring.services.exceptions.ActionNotAllowedException;
import com.melidh.desafiospring.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) throw new UserNotFoundException("User not found. Id: "+id);

        return userOptional.get();
    }

    public void followSeller(Integer userId, Integer userIdToFollow) {

        if(userId == userIdToFollow) throw new ActionNotAllowedException("User cannot follow self");

        User customer = findById(userId);
        User seller = findById(userIdToFollow);

        customer.getFollowing().add(seller);
        seller.getFollowers().add(customer);

        userRepository.save(customer);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserFollowCountDTO getFollowersCount(Integer id) {
        User user = findById(id);
        UserFollowCountDTO userFollowCountDTO = new UserFollowCountDTO(user);

        return userFollowCountDTO;
    }

    public UserFollowersDTO getUserAndFollowers(Integer id) {
        User user = findById(id);
        UserFollowersDTO userFollowers = new UserFollowersDTO(user);
        List<BaseUserDTO> baseUsers = user.getFollowers().stream().map(u -> new BaseUserDTO(u)).collect(Collectors.toList());

        userFollowers.getFollowers().addAll(baseUsers);

        return userFollowers;
    }

    public UserFollowingDTO getUserAndFollowed(Integer id) {
        User user = findById(id);
        UserFollowingDTO userFollowed = new UserFollowingDTO(user);
        List<BaseUserDTO> baseUsers = user.getFollowing().stream().map(u -> new BaseUserDTO(u)).collect(Collectors.toList());

        userFollowed.getFollowing().addAll(baseUsers);

        return userFollowed;
    }

}
