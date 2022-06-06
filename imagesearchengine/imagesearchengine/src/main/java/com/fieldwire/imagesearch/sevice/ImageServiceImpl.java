package com.fieldwire.imagesearch.sevice;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fieldwire.imagesearch.entity.ImageEntity;
import com.fieldwire.imagesearch.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public List<ImageEntity> getFilteredImageList(String namePattern) {
		List<ImageEntity> imageList = imageRepository.findAll();
		List<ImageEntity> filterdImageList = new ArrayList<>();
		if(!imageList.isEmpty()) {
			for(ImageEntity image: imageList) {
				if(image.getName().matches(namePattern+"\\w")) filterdImageList.add(image);
			}
		}
		return filterdImageList;
	}
	
	@Override
	public List<ImageEntity> getImageList() {		
		return  imageRepository.findAll();
	}

	@Override
	public ImageEntity addImage(ImageEntity image) {
		
		return imageRepository.save(image);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public byte[] getImageById(Long id) {		
		return imageRepository.existsById(id) ? imageRepository.getById(id).getImage() : null;
	}

	public BufferedImage convertToImage(byte[] imageData) throws IOException{
	    return ImageIO.read(new ByteArrayInputStream(imageData));

	}

	@SuppressWarnings("deprecation")
	@Override
	public ImageEntity getImage(Long id) {
		return imageRepository.getById(id);
	}
}
