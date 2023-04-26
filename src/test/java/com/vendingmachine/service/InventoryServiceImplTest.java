package com.vendingmachine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vendingmachine.dto.Product;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InventoryServiceImplTest {

	@Autowired
	private InventoryService inventoryService;

	@Before
	public void before() {
		Map<Product, Integer> products = inventoryService.getAll();

		for (Product product : products.keySet()) {
			inventoryService.remove(product.getId());
		}
	}

	@Test
	public void testAddProduct_shouldSuceed() {

		inventoryService.add(Product.WATER);
		Map<Product, Integer> products = inventoryService.getAll();

		assertTrue(products.size() == 1 && products.get(Product.WATER) == 1);

	}

	@Test
	public void testAddTenDifferentProducts_shouldSuceed() {

		inventoryService.add(Product.WATER);
		inventoryService.add(Product.WATER);
		inventoryService.add(Product.WATER);

		inventoryService.add(Product.WAFFLE);
		inventoryService.add(Product.WAFFLE);

		inventoryService.add(Product.BEER);

		inventoryService.add(Product.CHOCOLATE);
		inventoryService.add(Product.CHOCOLATE);
		inventoryService.add(Product.CHOCOLATE);
		inventoryService.add(Product.CHOCOLATE);

		Map<Product, Integer> products = inventoryService.getAll();

		assertTrue(products.size() == 4);
		assertTrue(products.get(Product.WATER) == 3);
		assertTrue(products.get(Product.WAFFLE) == 2);
		assertTrue(products.get(Product.BEER) == 1);
		assertTrue(products.get(Product.CHOCOLATE) == 4);

	}

	@Test
	public void testUpdateProduct_shouldSuceed() {

		inventoryService.add(Product.WATER);
		Map<Product, Integer> products = inventoryService.getAll();

		assertTrue(products.size() == 1 && products.get(Product.WATER) == 1);

		inventoryService.update(1, Product.BEER);

		assertTrue(products.size() == 1 && products.get(Product.BEER) == 1);

	}

	@Test
	public void testRemoveProductWhenThereIsOnlyOneProductInMachine_shouldSuceed() {

		inventoryService.add(Product.WATER);
		Map<Product, Integer> products = inventoryService.getAll();

		assertTrue(products.size() == 1 && products.get(Product.WATER) == 1);

		inventoryService.remove(1);

		assertEquals(0, products.size());

	}

	@Test
	public void testRemoveProductWhenThereIsMoreThanOneProductInMachine_shouldSuceed() {

		inventoryService.add(Product.WATER);
		inventoryService.add(Product.WATER);

		Map<Product, Integer> products = inventoryService.getAll();

		assertTrue(products.size() == 1 && products.get(Product.WATER) == 2);

		inventoryService.remove(1);

		assertTrue(products.size() == 1 && products.get(Product.WATER) == 1);

	}

}
