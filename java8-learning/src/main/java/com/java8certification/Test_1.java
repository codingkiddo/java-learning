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
		Product product = new Product();
		product.price = 200;
		double newPrice = 100;
		
		Test_1 t = new Test_1();
		t.updatePrice(product, newPrice);
		System.out.println(product.price + " : " + newPrice);
	}

}
