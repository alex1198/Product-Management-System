package com.alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.entity.Product;
import com.alex.service.EcommerceService;

@RestController
@RequestMapping("/ecommerce")
public class EcommerceController {

	@Autowired
	EcommerceService service;

	// 1. create product
	@PostMapping("/createproducts")
	public Product save(@RequestBody Product product) {
		return service.createProduct(product);
	}

	// 2. get all products
	@GetMapping("/showproducts")
	public List<Product> getAll() {
		return service.getProducts();
	}

	// 3. get product by id
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	// 4. update price and stock
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		return service.update(id, product);
	}

	// 5. delete all
	@DeleteMapping("/deleteall")
	public String deleteAllProducts() {
		return service.deleteProducts();
	}

	// 6. delete by id
	@DeleteMapping("/deleteone/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	// 7. find by category
	@GetMapping("/category/{category}")
	public List<Product> findByCategory(@PathVariable String category) {
		return service.findCategory(category);
	}

	// 8. find by price greater than
	@GetMapping("/price/{price}")
	public List<Product> findByPriceGreaterThan(@PathVariable Double price) {
		return service.findByPriceGreaterThan(price);
	}

} // end class
