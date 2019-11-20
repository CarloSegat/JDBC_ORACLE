package com.accenture.entity;

public class Product {
	
	private int productId;
	private String description;
	private String name;
	private double standardCost;
	private double listPrice;
	private String categoryId;
	
	public Product(String desc, String name, double standardCost, 
		double listPrice, String categoryId, int productId) { 
		this.description = desc;
		this.name = name;
		this.standardCost = standardCost;
		this.listPrice = listPrice;
		this.categoryId = categoryId;
		this.productId = productId;
	}
	
	// no id
	public Product(String desc, String name, double standardCost, 
			double listPrice,String categoryId) { 
			this.description = desc;
			this.name = name;
			this.standardCost = standardCost;
			this.listPrice = listPrice;
			this.categoryId = categoryId;
		}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStandardCost() {
		return standardCost;
	}

	public void setStandardCost(double standardCost) {
		this.standardCost = standardCost;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Pruducto " + this.productId + " " + this.name + " etc.";
	}

}
