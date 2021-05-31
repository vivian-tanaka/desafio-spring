package com.melidh.desafiospring.repositories;

import com.melidh.desafiospring.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
