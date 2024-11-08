package com.grocery.app.controller;

import com.grocery.app.model.GroceryItem;
import com.grocery.app.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/items")
public class AdminController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping
    public GroceryItem addItem(@RequestBody GroceryItem item) {
        return groceryService.addGroceryItem(item);
    }

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return groceryService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        groceryService.deleteGroceryItem(id);
    }

    @PutMapping("/{id}")
    public GroceryItem updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return groceryService.updateGroceryItem(id, item);
    }

    @PatchMapping("/{id}/inventory")
    public GroceryItem updateInventory(@PathVariable Long id, @RequestBody Integer quantity) {
        return groceryService.updateInventory(id, quantity);
    }
}