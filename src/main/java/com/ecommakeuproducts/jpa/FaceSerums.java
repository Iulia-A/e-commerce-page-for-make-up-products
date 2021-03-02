package com.ecommakeuproducts.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "faceSerums")
public class FaceSerums extends Skin {

	public FaceSerums(Long id, String brand, String name, String description, String ingredients, double price,
			String currency, double size, String sizeMeasurement, String imagePath) {
		super(id, brand, name, description, ingredients, price, currency, size, sizeMeasurement, imagePath);
	}

	public FaceSerums() {
		// TODO Auto-generated constructor stub
	}

	
}
