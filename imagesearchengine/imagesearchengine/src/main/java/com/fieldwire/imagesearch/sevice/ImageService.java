package com.fieldwire.imagesearch.sevice;

import java.util.List;

import com.fieldwire.imagesearch.entity.ImageEntity;

public interface ImageService {
	List<ImageEntity> getFilteredImageList(String pattern);
	List<ImageEntity> getImageList(); 
	ImageEntity addImage(ImageEntity image);
	byte[] getImageById(Long id);
	ImageEntity getImage(Long id);
}
