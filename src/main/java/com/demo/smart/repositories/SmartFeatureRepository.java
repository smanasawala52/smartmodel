package com.demo.smart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.smart.model.SmartFeature;

public interface SmartFeatureRepository
		extends
			JpaRepository<SmartFeature, Long> {

}
