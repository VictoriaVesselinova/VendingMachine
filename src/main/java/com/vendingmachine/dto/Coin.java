package com.vendingmachine.dto;

public enum Coin {
	TEN_ST(10), TWENTY_ST(20), FIFTY_ST(50), ONE_LV(100), TWO_LV(200);

	private int value;

	Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
