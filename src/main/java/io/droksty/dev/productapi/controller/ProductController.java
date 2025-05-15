package io.droksty.dev.productapi.controller;

import io.droksty.dev.productapi.dto.ProductDTO;
import io.droksty.dev.productapi.entity.Product;
import io.droksty.dev.productapi.mapper.ProductMapper;
import io.droksty.dev.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /* ------- Endpoints ------- */

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> payload = ProductMapper.map(products);
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> createProduct( @RequestBody ProductDTO dto) {
        Product product = productService.createProduct(dto); // handle exceptions later
        ProductDTO payload = ProductMapper.map(product);
        return new ResponseEntity<>(payload, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }

}
