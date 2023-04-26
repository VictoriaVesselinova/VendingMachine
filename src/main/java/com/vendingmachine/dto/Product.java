package com.vendingmachine.dto;

public enum Product {

	WATER(1, 80), WAFFLE(2, 50), BEER(3, 120), CHOCOLATE(4, 250);

	private int id;
	private int price;

	Product(int id, int price) {
		this.id = id;
		this.price = price;
	}

	public int getId() {
		return this.id;
	}

	public int getPrice() {
		return this.price;
	}

}
