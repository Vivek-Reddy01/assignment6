package com.assignment6.problem01;

import java.io.Serializable;
import java.time.LocalDateTime;

class CartItems implements Serializable {
	Product product;
	int quantity;
	LocalDateTime addedTimestamp;
	public CartItems(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.addedTimestamp=LocalDateTime.now();
		}
}
