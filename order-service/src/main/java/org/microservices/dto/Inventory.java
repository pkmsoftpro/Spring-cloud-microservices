package org.microservices.dto;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    private Long id;
    private String skuCode;
    private Integer quantity;
}
