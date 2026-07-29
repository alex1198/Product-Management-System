package com.alex.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productName;
	
	@Column(unique=true)
	private String productCode;
	
	private String category;
	
	private Double price;
	
	private int stockQuantity;
	
	private String brand;
	
	private Double rating;
	
	private String description;
	
	private String availabilityStatus;
	
	public Product()
	{
		
	}

	/**
	 * @param id
	 * @param productName
	 * @param productCode
	 * @param category
	 * @param price
	 * @param stockQuantity
	 * @param brand
	 * @param rating
	 * @param description
	 * @param availabilityStatus
	 */
	public Product(Long id, String productName, String productCode, String category, Double price, int stockQuantity,
			String brand, Double rating, String description, String availabilityStatus) {
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.brand = brand;
		this.rating = rating;
		this.description = description;
		this.availabilityStatus = availabilityStatus;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @return the stockQuantity
	 */
	public int getStockQuantity() {
		return stockQuantity;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the availabilityStatus
	 */
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @param stockQuantity the stockQuantity to set
	 */
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param availabilityStatus the availabilityStatus to set
	 */
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	
	
}
