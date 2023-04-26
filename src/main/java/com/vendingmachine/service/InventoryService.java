package com.vendingmachine.service;

import java.util.Map;

import com.vendingmachine.dto.Product;

public interface InventoryService {

	public void add(Product product);

	public void update(int oldProductId, Product newProduct);

	public void remove(int id);

	public Map<Product, Integer> getAll();

}
