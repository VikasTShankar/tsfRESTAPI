package com.crudapi.productrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapi.productrest.model.Product;
import com.crudapi.productrest.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//Create operation
	public Product create(String productName,String brand, int quantity) {
		return productRepository.save(new Product(productName, brand, quantity));
	}
		
	//Retrieve operation
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	public Product getByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}
	//Update operation
	public Product update(String productName,String brand, int quantity) {
		Product p=productRepository.findByProductName(productName);
		p.setQuantity(quantity);
		p.setProductName(productName);
		p.setBrand(brand);
		return productRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		productRepository.deleteAll();
	}
	public void delete(String productName) {
		Product p=productRepository.findByProductName(productName);
		productRepository.delete(p);
	}
	}