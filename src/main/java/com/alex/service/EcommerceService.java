package com.alex.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.entity.Product;
import com.alex.repository.EcommerceRepository;

@Service
public class EcommerceService {

	@Autowired
	EcommerceRepository repository;

	// ================ create product ==================
	public Product createProduct(Product product) {

		// Rule 1: Price must be positive
		if (product.getPrice() < 0) {
			throw new RuntimeException("Price must be positive");
		}

		// Rule 2: Stock quantity cannot be negative
		if (product.getStockQuantity() < 0) {
			throw new RuntimeException("Stock Quantity cannot be negative.");
		}

		// Rule 3: Set availability status
		if (product.getStockQuantity() == 0) {
			product.setAvailabilityStatus("OUT_OF_STOCK");
		} else {
			product.setAvailabilityStatus("IN_STOCK");
		}

		return repository.save(product);
	}

	// =============== get all products ==================
	public List<Product> getProducts() {
		return repository.findAll();
	}

	// =================== get product by id ====================
	public Product getProductById(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	// ====================== update price and stock =================
	public Product update(int id, Product newProduct) {
		Optional<Product> optional = repository.findById(id);

		if (optional.isPresent()) {

			Product existingProduct = optional.get();

			// Rule 1: Price must be positive
			if (newProduct.getPrice() < 0) {
				throw new RuntimeException("Price must be positive");
			}

			// Rule 2: Stock quantity cannot be negative
			if (newProduct.getStockQuantity() < 0) {
				throw new RuntimeException("Stock Quantity cannot be negative.");
			}

			// Update product fields
//			existingProduct.setProductName(newProduct.getProductName());
//			existingProduct.setProductCode(newProduct.getProductCode());
//			existingProduct.setCategory(newProduct.getCategory());
			existingProduct.setPrice(newProduct.getPrice());
			existingProduct.setStockQuantity(newProduct.getStockQuantity());
//			existingProduct.setBrand(newProduct.getBrand());
//			existingProduct.setRating(newProduct.getRating());
//			existingProduct.setDescription(newProduct.getDescription());

			// Business Rule 3: Set availability status automatically
			if (newProduct.getStockQuantity() == 0) {
				existingProduct.setAvailabilityStatus("OUT_OF_STOCK");
			} else {
				existingProduct.setAvailabilityStatus("IN_STOCK");
			}

			return repository.save(existingProduct);

		}

		throw new RuntimeException("Product not found: " + id);
	}

	// ============= delete product ============
	public String deleteProduct(int id) {
		if (!repository.existsById(id)) {
			return "Product not found: " + id;
		}
		repository.deleteById(id);
		return "Product is deleted";
	}

	// =============== delete all products =============
	public String deleteProducts() {
		repository.deleteAll();
		return "Products are deleted";
	}

	// =============== find by category ===============
	public List<Product> findCategory(String category) {
		List<Product> products = repository.findAll().stream()
				.filter(product -> product.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());

		if (products.isEmpty()) {
			throw new RuntimeException("No products found for category: " + category);
		}

		return products;
	}

	// ==================== find by price greater than ==================
	public List<Product> findByPriceGreaterThan(Double price) {

		List<Product> products = repository.findAll().stream().filter(product -> product.getPrice() > price) // checking
																												// the
																												// logic
				.collect(Collectors.toList());

		if (products.isEmpty()) {
			throw new RuntimeException("No products found with price greater than " + price);
		}

		return products;
	}

} // class end
