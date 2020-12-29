package com.ecommakeuproducts.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "skinProducts")
public abstract class Skin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "brand")
	private String brand;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "ingredients")
	private String ingredients;

	@Column(name = "price")
	private double price;
	
	@Column(name = "currency")
	private String currency;

	@Column(name = "size")
	private double size;
	
	@Column(name ="sizeMeasurement")
	private String sizeMeasurement;
	@Column(name = "imagePath")
	private String imagePath;

	public Skin() {
		super();
	}

	
	public Skin(Long id, String brand, String name, String description, String ingredients, double price,
			String currency, double size, String sizeMeasurement, String imagePath) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.price = price;
		this.currency = "EUR";
		this.size = size;
		this.sizeMeasurement = "ml";
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


	public String getCurrency() {
		return currency;
	}


	public String getSizeMeasurement() {
		return sizeMeasurement;
	}



	
	
}
