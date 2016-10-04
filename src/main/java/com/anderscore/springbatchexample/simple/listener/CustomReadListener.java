package com.anderscore.springbatchexample.simple.listener;

import org.springframework.batch.core.ItemReadListener;

import com.anderscore.springbatchexample.simple.model.Product;

public class CustomReadListener implements ItemReadListener<Product> {

	@Override
	public void beforeRead() {
		System.out.println("ItemReadListener - beforeRead");
	}

	@Override
	public void afterRead(Product item) {
		System.out.println("ItemReadListener - afterRead (Product ID: " + item.getId() + ")");
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("ItemReadListener - onReadError");
	}
}