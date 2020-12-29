package com.ecommakeuproducts.jpa;

public abstract class Fragrance {
	private Long id;
	private String brand;
	private String name;
	private String description;
	private String ingredients;
	private double price;
	final private String CURRENCY = "EUR";
	private double size;
	final private String SIZEMEASUREMENT = "ml";
	private String imagePath;

	public Fragrance(String brand, String name, String description, String ingredients, double price, double size,
			String imagePath) {
		super();
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.price = price;
		this.size = size;
		this.imagePath = imagePath;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be less than 0");
		}
		this.price = price;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		if (size < 0) {
			throw new IllegalArgumentException("Size cannot be less than 0");
		}
		this.size = size;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
