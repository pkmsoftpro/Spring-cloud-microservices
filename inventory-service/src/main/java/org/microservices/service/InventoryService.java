package org.microservices.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.microservices.entity.Inventory;
import org.microservices.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public Inventory findBySkuCode(String skuCode) throws InterruptedException {
        //Thread.sleep(10000);
        log.info(" Start -- Received request to check stock for skuCode {}, with quantity {}", skuCode);
        Inventory isInStock = inventoryRepository.findBySkuCode(skuCode);
        log.info(" End -- Product with skuCode {}, and quantity {}, is in stock - {}", skuCode, isInStock);
        return isInStock;
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }
}
