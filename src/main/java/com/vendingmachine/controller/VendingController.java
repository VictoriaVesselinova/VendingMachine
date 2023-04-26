package com.vendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.dto.Coin;
import com.vendingmachine.dto.Product;
import com.vendingmachine.service.VendingService;

@RestController
@RequestMapping("/vending")
public class VendingController {

	@Autowired
	private VendingService vendingService;

	@PostMapping("/insert")
	public void insert(@RequestBody Coin coin) {
		vendingService.insert(coin);
	}

	@PostMapping("/reset")
	public List<Coin> reset() {
		return vendingService.reset();
	}

	@PostMapping("/buy/{id}")
	public Product buy(@PathVariable int id) {
		return vendingService.buy(id);
	}

}
