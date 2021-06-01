package com.melidh.desafiospring.resources;

import com.melidh.desafiospring.domain.dto.PostRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping("/newpost")
    public ResponseEntity<Void> postNewProduct(@RequestBody PostRequestDTO postRequestDTO){

        return ResponseEntity.ok().build();
    }
}
