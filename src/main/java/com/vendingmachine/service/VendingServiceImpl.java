package com.vendingmachine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendingmachine.dto.Coin;
import com.vendingmachine.dto.Product;
import com.vendingmachine.util.VendingMachineUtil;

@Service
public class VendingServiceImpl implements VendingService {

	private List<Coin> coins = new ArrayList<>();

	@Autowired
	private InventoryService inventoryService;

	private int currentBalance;

	@Override
	public void insert(Coin coin) {

		currentBalance += coin.getValue();
		coins.add(coin);

	}

	@Override
	public List<Coin> reset() {
		currentBalance = 0;
		List<Coin> coppyOfCurrentCoins = new ArrayList<Coin>(coins);
		coins = new ArrayList<>();
		return coppyOfCurrentCoins;
	}

	@Override
	public Product buy(int id) {

		Product product = VendingMachineUtil.getProductById(id);

		if (isThereEnoughMoney(currentBalance, product)) {
			inventoryService.remove(id);
			currentBalance -= product.getPrice();
		} else {
			product = null;
		}

		return product;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	private boolean isThereEnoughMoney(int currentBalance, Product product) {
		return currentBalance >= product.getPrice();
	}

}
