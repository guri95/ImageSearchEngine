package com.fieldwire.imagesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImageSearchAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageSearchAppApplication.class, args);
	}

}
