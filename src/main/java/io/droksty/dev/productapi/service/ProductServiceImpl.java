package io.droksty.dev.productapi.service;

import io.droksty.dev.productapi.dto.ProductDTO;
import io.droksty.dev.productapi.entity.Product;
import io.droksty.dev.productapi.exception.ResourceNotFoundException;
import io.droksty.dev.productapi.mapper.ProductMapper;
import io.droksty.dev.productapi.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReadPreferenceAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ReadPreferenceAware readPreferenceAware;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ReadPreferenceAware readPreferenceAware) {
        this.productRepository = productRepository;
        this.readPreferenceAware = readPreferenceAware;
    }


    /* ------- Public API ------- */

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product createProduct(ProductDTO dto) {
        Product product = ProductMapper.map(dto);
        return productRepository.save(product);
    }


    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id))
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        productRepository.deleteById(id);
    }


    @Override
    public Product updateProduct(ProductDTO dto) {
        return null;
    }



    @Override
    public Product getProduct(String id) {
        return null;
    }

}
