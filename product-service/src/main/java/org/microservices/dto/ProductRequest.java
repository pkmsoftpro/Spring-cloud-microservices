package org.microservices.dto;

import java.math.BigDecimal;

/*
{
  "id": "123",
  "name": "Sample Product",
  "description": "This is a sample product description.",
  "skuCode": "SKU12345",
  "price": 19.99
}
 */
public record ProductRequest(String id, String name, String description,
                             String skuCode, BigDecimal price) { }