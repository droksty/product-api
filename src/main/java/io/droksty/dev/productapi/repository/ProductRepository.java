package io.droksty.dev.productapi.repository;

import io.droksty.dev.productapi.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
