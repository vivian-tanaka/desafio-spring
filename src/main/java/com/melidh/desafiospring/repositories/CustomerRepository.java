package com.melidh.desafiospring.repositories;

import com.melidh.desafiospring.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
