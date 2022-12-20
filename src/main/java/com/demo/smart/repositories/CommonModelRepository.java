package com.demo.smart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.smart.model.CommonModel;

public interface CommonModelRepository
		extends
			JpaRepository<CommonModel, Long> {

}
