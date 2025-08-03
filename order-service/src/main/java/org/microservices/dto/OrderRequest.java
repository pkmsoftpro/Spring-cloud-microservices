package org.microservices.dto;

import java.math.BigDecimal;

/*
{
  "id": 12345,
  "orderNumber": "ORD-2025-0001",
  "skuCode": "SKU12345",
  "price": 99.99,
  "quantity": 3,
  "userDetails": {
    "email": "john.doe@example.com",
    "firstName": "John",
    "lastName": "Doe"
  }
}
 */

public record OrderRequest(Long id, String orderNumber, String skuCode,
                           BigDecimal price, Integer quantity, UserDetails userDetails) {

    public record UserDetails(String email, String firstName, String lastName) {}
}
