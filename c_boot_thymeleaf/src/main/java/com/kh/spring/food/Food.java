package com.kh.spring.food;

public class Food {

	private String name;
	private int price;
	
	public Food() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + "]";
	}
	
	
}