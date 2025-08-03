package org.microservices.service;

import lombok.RequiredArgsConstructor;
import org.microservices.dto.Inventory;
import org.microservices.dto.OrderRequest;
import org.microservices.entity.Order;
import org.microservices.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final WebClient.Builder webClientBuilder;
    private final OrderRepository orderRepository;

    public Order placeOrder(OrderRequest orderRequest) {

        Inventory inventoryResponse = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", orderRequest.skuCode()).build())
                .retrieve()
                .bodyToMono(Inventory.class)
                .block();

        if(inventoryResponse != null){
          return orderRepository.save(
              Order.builder()
                  .price(orderRequest.price())
                  .quantity(orderRequest.quantity())
                  .skuCode(orderRequest.skuCode())
                  .build());
        }
        throw new IllegalArgumentException("Invalid Order Request");
    }
}
