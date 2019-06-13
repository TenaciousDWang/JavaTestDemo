package com.wanghao.collectionTest.entity;

public class Fruit {
	
	private String id,name,type;
	private int price;
	
	public Fruit() {

	}
	
	public Fruit(String id,String name,String type,int price) {
		this.id = id;
		this.name=name;
		this.type=type;
		this.price=price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	

}


