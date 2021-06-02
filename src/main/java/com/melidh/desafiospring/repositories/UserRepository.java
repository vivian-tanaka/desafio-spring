package com.melidh.desafiospring.repositories;

import com.melidh.desafiospring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
