package com.assignment6.problem01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EcommerceShoppingCart {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        Product p1 = new Product("P101", "Laptop", 50000, 10);
	        Product p2 = new Product("P102", "Phone", 20000, 20);
	        Product p3 = new Product("P103", "Keyboard",5000, 10);
	        Map<String, Product> store = new HashMap<>();
	        store.put(p1.productId, p1);
	        store.put(p2.productId, p2);
	        Cart cart = new Cart();
	        while (true) {
	            System.out.println("\n1.Add 2.Remove 3.Update 4.View 5.Total 6.Exit");
	            int choice = sc.nextInt();
	 
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Product ID: ");
	                    String id = sc.next();
	                    System.out.print("Enter Quantity: ");
	                    int qty = sc.nextInt();
	 
	                    if (store.containsKey(id)) {
	                        cart.addToCart(store.get(id), qty);
	                    } else {
	                        System.out.println("Product not found!");
	                    }
	                    break;
	 
	                case 2:
	                    System.out.print("Enter Product ID: ");
	                    cart.removeFromCart(sc.next());
	                    break;
	 
	                case 3:
	                    System.out.print("Enter Product ID: ");
	                    String pid = sc.next();
	                    System.out.print("Enter New Quantity: ");
	                    int newQty = sc.nextInt();
	                    cart.updateQuantity(pid, newQty);
	                    break;
	 
	                case 4:
	                    cart.displayCart();
	                    break;
	 
	                case 5:
	                    double total = cart.calculateTotal();
	                    System.out.println("Total: " + total);
	 
	                    System.out.print("Apply Discount? (yes/no): ");
	                    String ans = sc.next();
	 
	                    if (ans.equalsIgnoreCase("yes")) {
	                        System.out.print("Type (PERCENT/FIXED): ");
	                        String type = sc.next();
	                        System.out.print("Value: ");
	                        double val = sc.nextDouble();
	 
	                        total = cart.applyDiscount(total, type, val);
	                        System.out.println("Final Total: " + total);
	                    }
	                    break;
	 
	                case 6:
	                    System.out.println("Thank you!");
	                    return;
	            }
	        }
	}

}
