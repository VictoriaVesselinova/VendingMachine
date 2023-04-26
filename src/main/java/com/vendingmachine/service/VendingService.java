package com.vendingmachine.service;

import java.util.List;

import com.vendingmachine.dto.Coin;
import com.vendingmachine.dto.Product;

public interface VendingService {

	public void insert(Coin coin);

	public List<Coin> reset();

	public Product buy(int id);

}
