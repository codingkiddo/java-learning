package com.java8certification;

class Product {
	double price;
}

public class Test_1 {

	public void updatePrice(Product product, double price) {
		price = price * 2;
		product.price = product.price + price;
	}
	
	public static void main(String[] args) {
		
	}

}
