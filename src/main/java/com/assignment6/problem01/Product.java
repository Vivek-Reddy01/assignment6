package com.assignment6.problem01;

import java.io.Serializable;

public class Product implements Serializable{
	String productId;
	String name;
	double price;
	int stock;
	public Product(String productId, String name, double price, int stock) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

}
