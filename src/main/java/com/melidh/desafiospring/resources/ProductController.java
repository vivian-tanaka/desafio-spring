package com.melidh.desafiospring.resources;

import com.melidh.desafiospring.domain.dto.PostDTO;
import com.melidh.desafiospring.domain.dto.UserPostsDTO;
import com.melidh.desafiospring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> postNewProduct(@RequestBody PostDTO postDTO){
        productService.addPost(postDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostsDTO> getRecentPosts(@PathVariable Integer userId){
        UserPostsDTO userPostsDTO = productService.findAllRecentPosts(userId);

        return ResponseEntity.ok().body(userPostsDTO);
    }
}
