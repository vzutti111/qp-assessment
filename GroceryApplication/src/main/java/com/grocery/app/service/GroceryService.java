package com.grocery.app.service;

import com.grocery.app.model.GroceryItem;
import com.grocery.app.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    private GroceryItemRepository repository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return repository.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public void deleteGroceryItem(Long id) {
        repository.deleteById(id);
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem updatedItem) {
        GroceryItem item = repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(updatedItem.getName());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());
        return repository.save(item);
    }

    public GroceryItem updateInventory(Long id, Integer quantity) {
        GroceryItem item = repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setQuantity(quantity);
        return repository.save(item);
    }
}