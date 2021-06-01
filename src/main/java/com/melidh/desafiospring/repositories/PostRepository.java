package com.melidh.desafiospring.repositories;

import com.melidh.desafiospring.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
