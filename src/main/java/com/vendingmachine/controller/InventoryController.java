package com.vendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.dto.Product;
import com.vendingmachine.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping
	public void add(@RequestBody Product product) {
		inventoryService.add(product);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable int oldProductId, @RequestBody Product newProduct) {
		inventoryService.update(oldProductId, newProduct);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		inventoryService.remove(id);
	}

}
