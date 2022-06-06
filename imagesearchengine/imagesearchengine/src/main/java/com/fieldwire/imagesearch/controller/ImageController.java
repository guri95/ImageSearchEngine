package com.fieldwire.imagesearch.controller;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fieldwire.imagesearch.entity.ImageEntity;
import com.fieldwire.imagesearch.sevice.ImageService;

@Controller
public class ImageController {
	@Autowired
	ImageService imageService;
	
	@GetMapping("/")
	public String show(Model map ) {
		map.addAttribute("images", imageService.getImageList());
		return "images";
	}

	@GetMapping("/image/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<ImageEntity> imageEntity)
			throws IOException {
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(imageService.getImageById(id));
		response.getOutputStream().close();
	}

	@GetMapping("/image/imageDetails")
	String showProductDetails(@RequestParam("id") Long id, Model model) {
		try {
			ImageEntity imageEntity = imageService.getImage(id);
			model.addAttribute("id", imageEntity.getId());
			model.addAttribute("description", imageEntity.getDescription());
			model.addAttribute("name", imageEntity.getName());
			return "imagedetails";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}
}
