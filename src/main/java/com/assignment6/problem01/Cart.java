package com.assignment6.problem01;

import java.util.LinkedHashMap;
import java.util.Map;

class Cart {
    private Map<String, CartItems> cartItems = new LinkedHashMap<>();
    private static final int MAX_ITEMS = 50;
 
    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity");
            return;
        }
        if (cartItems.size() >= MAX_ITEMS && !cartItems.containsKey(product.productId)) {
            System.out.println("Cart limit reached");
            return;
        }
        if (product.stock < quantity) {
            System.out.println("Not enough stock!");
            return;
        }
        if (cartItems.containsKey(product.productId)) {
            CartItems item = cartItems.get(product.productId);
            item.quantity += quantity;
        } else {
            cartItems.put(product.productId, new CartItems(product, quantity));
        }
 
        product.stock -= quantity;
        System.out.println("Added to cart!");
    }
    
    public void removeFromCart(String productId) {
        if (!cartItems.containsKey(productId)) {
            System.out.println("Item not in cart!");
            return;
        }
 
        CartItems item = cartItems.remove(productId);
        item.product.stock += item.quantity;
 
        System.out.println("Item removed!");
    }
 
    public void updateQuantity(String productId, int quantity) {
        if (!cartItems.containsKey(productId)) {
            System.out.println("Item not found!");
            return;
        }
 
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }
 
        CartItems item = cartItems.get(productId);
 
        int diff = quantity - item.quantity;
 
        if (item.product.stock < diff) {
            System.out.println("Not enough stock!");
            return;
        }
 
        item.product.stock -= diff;
        item.quantity = quantity;
 
        System.out.println("Quantity updated!");
    }
 
    public double calculateTotal() {
        double total = 0;
 
        for (CartItems item : cartItems.values()) {
            total += item.product.price * item.quantity;
        }
 
        return total;
    }
 
    public double applyDiscount(double total, String type, double value) {
        if (type.equalsIgnoreCase("PERCENT")) {
            total = total - (total * value / 100);
        } else if (type.equalsIgnoreCase("FIXED")) {
            total = total - value;
        }
        return Math.max(total, 0);
    }
 
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
 
        for (CartItems item : cartItems.values()) {
            System.out.println(item.product.name +  " | Qty: " + item.quantity +  " | Price: " + item.product.price);
        }
    }
}