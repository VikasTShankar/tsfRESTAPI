package com.crudapi.productrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudapi.productrest.model.Product;
import com.crudapi.productrest.service.ProductService;
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("product/create")
	public String create(@RequestParam String productName, @RequestParam String brand, @RequestParam int quantity) {
		Product p= productService.create(productName, brand, quantity);
		return p.toString();
	}
	
	@GetMapping("product/get")
	public Product getProduct(@RequestParam String productName) {
		return productService.getByProductName(productName);
	}
	@GetMapping("product/getAll")
	public List<Product> getAll(){
		return productService.getAll();
	}
	@PutMapping("product/update")
	public String update(@RequestParam String productName, @RequestParam String brand, @RequestParam int quantity) {
		Product p = productService.update(productName, brand, quantity);
		return p.toString();
	}
	@DeleteMapping("product/delete")
	public String delete(@RequestParam String productName) {
		productService.delete(productName);
		return "Deleted "+productName;
	}
	@DeleteMapping ("product/deleteAll")
	public String deleteAll() {
		productService.deleteAll();
		return "Deleted all records";
	}
	
}

