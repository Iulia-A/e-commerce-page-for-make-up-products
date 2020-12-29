package com.ecommakeuproducts.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "faceOils")
public class FaceOils extends Skin {

	public FaceOils(Long id, String brand, String name, String description, String ingredients, double price,
			String currency, double size, String sizeMeasurement, String imagePath) {
		super(id, brand, name, description, ingredients, price, currency, size, sizeMeasurement, imagePath);
	}

	

}
