package com.melidh.desafiospring;

import com.melidh.desafiospring.domain.Customer;
import com.melidh.desafiospring.domain.Seller;
import com.melidh.desafiospring.repositories.CustomerRepository;
import com.melidh.desafiospring.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DesafioSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesafioSpringApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Initializing db");

        Customer c1 = new Customer(null, "Joao");
        Customer c2 = new Customer(null, "Julia");
        Customer c3 = new Customer(null, "Jose");

        Seller s1 = new Seller(null,"Mariano");
        Seller s2 = new Seller(null,"Mafaldaa");
        Seller s3 = new Seller(null,"Marcio");

        s1.getFollowers().add(c1);
        c1.getFollowing().add(s1);

        customerRepository.saveAll(Arrays.asList(c1,c2,c3));
        sellerRepository.saveAll(Arrays.asList(s1,s2,s3));
    }

}
