package com.crudapi.productrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="product")
public class Product {
	@Id
	String id;
	String productName;
	String brand;
	int    quantity;
	
	public Product(String productName, String brand, int quantity) {
		this.productName = productName;
		this.brand = brand;
		this.quantity = quantity;
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Product Name:"+productName+" Brand:"+brand+" Quantity:"+quantity;
	}
}

