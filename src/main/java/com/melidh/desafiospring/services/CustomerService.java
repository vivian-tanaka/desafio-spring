package com.melidh.desafiospring.services;

import com.melidh.desafiospring.domain.Customer;
import com.melidh.desafiospring.domain.Seller;
import com.melidh.desafiospring.repositories.CustomerRepository;
import com.melidh.desafiospring.repositories.SellerRepository;
import com.melidh.desafiospring.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerService sellerService;

    public Customer findById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(!customerOptional.isPresent()) throw new UserNotFoundException("Customer not found. Id: "+id);

        return customerOptional.get();
    }

    public void followSeller(Integer userId, Integer userIdToFollow) {
        Customer customer = findById(userId);
        Seller seller = sellerService.findById(userIdToFollow);

        customer.getFollowing().add(seller);
        seller.getFollowers().add(customer);

        customerRepository.save(customer);
        sellerService.update(seller);

    }
}
