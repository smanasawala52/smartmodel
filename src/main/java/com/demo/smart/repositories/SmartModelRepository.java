package com.demo.smart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.smart.model.SmartModel;

public interface SmartModelRepository extends JpaRepository<SmartModel, Long> {

}
