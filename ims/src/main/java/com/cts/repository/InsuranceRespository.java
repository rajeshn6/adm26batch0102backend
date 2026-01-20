package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Insurance;



public interface InsuranceRespository extends JpaRepository<Insurance, Integer> {

}
