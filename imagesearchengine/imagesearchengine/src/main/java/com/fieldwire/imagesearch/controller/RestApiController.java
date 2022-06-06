package com.fieldwire.imagesearch.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fieldwire.imagesearch.entity.ImageEntity;
import com.fieldwire.imagesearch.model.ImageUploadResponse;
import com.fieldwire.imagesearch.sevice.ImageService;

@RestController
@RequestMapping("/imagesearch")
public class RestApiController {
	@Autowired
	ImageService imageService;

	@GetMapping("/getImage/{pattern}")
	public List<ImageEntity> getImageByName(@PathVariable String name) {		
		return imageService.getFilteredImageList(name);
	}

	@PostMapping(value = "/addImage", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<ImageUploadResponse> addImage(@RequestPart(value = "name", required = true) String name,
			@RequestPart("decription") String decription,
			@RequestPart(value = "file", required = true) MultipartFile file) throws IOException {
		
		ImageEntity newImage = new ImageEntity();
		newImage.setName(name);
		newImage.setImage(file.getBytes());

		decription = !decription.isEmpty() ? decription : name;
		newImage.setDescription(decription);
		imageService.addImage(newImage);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ImageUploadResponse("Image uploaded sucessfully: " + file.getOriginalFilename()));
	}

}
