package com.ecommakeuproducts.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "eyeCreams")
public class EyeCreamsAndGels extends Skin {

	public EyeCreamsAndGels(Long id, String brand, String name, String description, String ingredients, double price,
			String currency, double size, String sizeMeasurement, String imagePath) {
		super(id, brand, name, description, ingredients, price, currency, size, sizeMeasurement, imagePath);
	}

	public EyeCreamsAndGels() {
		// TODO Auto-generated constructor stub
	}

}
