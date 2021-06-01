package com.melidh.desafiospring.resources;

import com.melidh.desafiospring.domain.Customer;
import com.melidh.desafiospring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable Integer id){
        Customer customer = customerService.findById(id);

        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){

        customerService.followSeller(userId,userIdToFollow);

        return ResponseEntity.ok().build();
    }
}
