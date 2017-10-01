package com.h.dto;

public class Category {
	
	private int id;
	private String name;
	private String imageUrl;
	private String descriptsion;
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
	
	

}
