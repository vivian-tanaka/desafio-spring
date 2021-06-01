package com.melidh.desafiospring.services;

import com.melidh.desafiospring.domain.Seller;
import com.melidh.desafiospring.repositories.SellerRepository;
import com.melidh.desafiospring.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public Seller findById(Integer id) {
        Optional<Seller> sellerOptional = sellerRepository.findById(id);

        if(!sellerOptional.isPresent()) throw new UserNotFoundException("Seller not found. Id: "+id);

        return sellerOptional.get();
    }

    public void update(Seller seller) {
        findById(seller.getId());

        sellerRepository.save(seller);
    }
}
