package com.fieldwire.imagesearch.model;

import java.time.LocalDateTime;


public class ImageModel {
	private Long id;
	private String name;
	private String description;
    
	private LocalDateTime createdTime;
	public ImageModel() {
		
	}
	public ImageModel(Long id, String name, String description, LocalDateTime createdTime) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdTime = createdTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	
	
}