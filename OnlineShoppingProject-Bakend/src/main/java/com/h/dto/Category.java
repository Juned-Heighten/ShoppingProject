package com.h.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAT_TAB")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="description")
	private String descriptsion;
	@Column(name="is_active")
	private boolean active=true;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescriptsion() {
		return descriptsion;
	}
	public void setDescriptsion(String descriptsion) {
		this.descriptsion = descriptsion;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", descriptsion=" + descriptsion
				+ ", active=" + active + "]";
	}
	
	
	

}
