package org.microservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// create table product (price number(38,2), description varchar2(255 char), id varchar2(255 char) not null,
// name varchar2(255 char), sku_code varchar2(255 char), primary key (id));

//drop table product cascade constraints

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private String skuCode;
    private BigDecimal price;
}
