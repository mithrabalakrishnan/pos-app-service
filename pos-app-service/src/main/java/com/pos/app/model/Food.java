package com.pos.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer foodid;
	
	@Column
	private String food_name;
	
	@Column
	private String category;
	
	@Column
	private String rating;
	
	@Column
	private String price;
	
	@Column
	private String image;
	
	@Column
	private String status;
	
	
	
	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	



	public Food(Integer foodid, String food_name, String category, String rating, String price, String image,
			String status) {
		super();
		this.foodid = foodid;
		this.food_name = food_name;
		this.category = category;
		this.rating = rating;
		this.price = price;
		this.image = image;
		this.status = status;
	}





	



	public Integer getFoodid() {
		return foodid;
	}





	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}





	public String getFood_name() {
		return food_name;
	}





	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}





	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
