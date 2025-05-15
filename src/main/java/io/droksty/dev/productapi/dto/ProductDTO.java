package io.droksty.dev.productapi.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private double price;
    private boolean available;
    private Map<String, Object> attributes;
}
