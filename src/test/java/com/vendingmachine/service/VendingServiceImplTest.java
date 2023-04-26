package com.vendingmachine.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vendingmachine.dto.Coin;
import com.vendingmachine.dto.Product;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VendingServiceImplTest {

	@Autowired
	private VendingServiceImpl vendingServiceImpl;

	@Before
	public void before() {
		vendingServiceImpl.reset();
	}

	@Test
	public void testInsert_shouldSuceed() {
		vendingServiceImpl.insert(Coin.TEN_ST);

		assertEquals(10, vendingServiceImpl.getCurrentBalance());
	}

	@Test
	public void testReset_shouldSuceed() {
		vendingServiceImpl.insert(Coin.TEN_ST);
		vendingServiceImpl.insert(Coin.ONE_LV);
		vendingServiceImpl.insert(Coin.FIFTY_ST);

		List<Coin> returnedCoins = vendingServiceImpl.reset();

		assertEquals(0, vendingServiceImpl.getCurrentBalance());
		assertEquals(3, returnedCoins.size());
		assertEquals(Coin.TEN_ST, returnedCoins.get(0));
		assertEquals(Coin.ONE_LV, returnedCoins.get(1));
		assertEquals(Coin.FIFTY_ST, returnedCoins.get(2));
	}

	@Test
	public void testBuy_shouldSuceed() {
		vendingServiceImpl.insert(Coin.TEN_ST);
		vendingServiceImpl.insert(Coin.TWENTY_ST);
		vendingServiceImpl.insert(Coin.FIFTY_ST);

		Product water = vendingServiceImpl.buy(1);

		assertEquals(water, Product.WATER);
		assertEquals(0, vendingServiceImpl.getCurrentBalance());

	}

	@Test
	public void testBuyWithNotEnoughtMoney_shouldSuceed() {
		vendingServiceImpl.insert(Coin.TEN_ST);

		Product water = vendingServiceImpl.buy(1);

		assertEquals(null, water);
		assertEquals(10, vendingServiceImpl.getCurrentBalance());

	}

}
