package io.droksty.dev.productapi.mapper;

import io.droksty.dev.productapi.dto.ProductDTO;
import io.droksty.dev.productapi.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    private ProductMapper() {}

    public static ProductDTO map(Product product) {
        return new ProductDTO(
                product.getId(), product.getName(),
                product.getDescription(), product.getPrice(),
                product.isAvailable(), product.getAttributes()
        );
    }

    public static Product map(ProductDTO dto) {
        return new Product(
                dto.getId(), dto.getName(),
                dto.getDescription(), dto.getPrice(),
                dto.isAvailable(), dto.getAttributes()
        );
    }

    public static List<ProductDTO> map(List<Product> products) {
        return products.stream()
                .map(ProductMapper::map)
                .collect(Collectors.toList());
    }
}
