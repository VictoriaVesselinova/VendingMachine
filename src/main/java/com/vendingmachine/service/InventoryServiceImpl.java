package com.vendingmachine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vendingmachine.dto.Product;
import com.vendingmachine.util.VendingMachineUtil;

@Service
public class InventoryServiceImpl implements InventoryService {

	private Map<Product, Integer> products = new HashMap<>();

	@Override
	public void add(Product product) {
		if (products.containsKey(product)) {
			products.put(product, (products.get(product) + 1));
		} else {
			products.put(product, 1);
		}
	}

	@Override
	public void update(int oldProductId, Product newProduct) {
		remove(oldProductId);
		add(newProduct);

	}

	@Override
	public void remove(int id) {
		Product product = VendingMachineUtil.getProductById(id);

		if (products.containsKey(product)) {
			if (products.get(product) == 1) {
				products.remove(product);
			}
			if (products.get(product) != null && products.get(product) > 1) {
				products.put(product, (products.get(product) - 1));
			}
		}

	}

	@Override
	public Map<Product, Integer> getAll() {
		return products;
	}

}
