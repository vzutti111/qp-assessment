package com.grocery.app.controller;


import com.grocery.app.model.GroceryItem;
import com.grocery.app.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class UserController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping
    public List<GroceryItem> viewItems() {
        return groceryService.getAllItems();
    }
}