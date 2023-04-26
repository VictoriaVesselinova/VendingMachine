package com.vendingmachine.util;

import java.util.Arrays;

import com.vendingmachine.dto.Product;

public class VendingMachineUtil {

	public static Product getProductById(int id) {

		return Arrays.stream(Product.values()).filter(product -> product.getId() == id).findFirst().get();

	}

}
