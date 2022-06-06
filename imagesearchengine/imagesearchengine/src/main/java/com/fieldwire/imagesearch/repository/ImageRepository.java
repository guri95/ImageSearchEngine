package com.fieldwire.imagesearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fieldwire.imagesearch.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}
