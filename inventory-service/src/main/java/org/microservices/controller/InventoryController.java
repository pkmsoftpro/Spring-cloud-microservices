package org.microservices.controller;

import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import org.microservices.entity.Inventory;
import org.microservices.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Inventory isInStock(@RequestParam("skuCode") String skuCode) throws InterruptedException {
        Inventory  inventory = inventoryService.findBySkuCode(skuCode);
        System.out.println("----------------------: " + inventory);
        return inventory;
    }
}
