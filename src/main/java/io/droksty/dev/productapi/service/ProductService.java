package io.droksty.dev.productapi.service;

import io.droksty.dev.productapi.dto.ProductDTO;
import io.droksty.dev.productapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product>   getAllProducts();
    Product         createProduct(ProductDTO dto);
    void            deleteProduct(String id);
    Product         updateProduct(ProductDTO dto);
    Product         getProduct(String id);
}
