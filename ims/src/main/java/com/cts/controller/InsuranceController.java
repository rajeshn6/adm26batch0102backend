package com.cts.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.InsuranceIdNotFoundException;
import com.cts.model.InsuranceDto;
import com.cts.service.InsuranceService;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/insurance")
@Slf4j
public class InsuranceController {
	@Autowired
	private InsuranceService insuranceService;
		
	@PostMapping // validation
	public InsuranceDto createInsurance(@Valid @RequestBody InsuranceDto insurance) {
		// send this insurance to insurance service
		log.info("Post has recived by server it is binded to insurance dto");
		log.info("Request is processed and preparing data");
		log.info("Call is made to service method");
		InsuranceDto i = insuranceService.createInsurance(insurance);
		return i;
	}

	@GetMapping
	public List<InsuranceDto> getAllInsurance() {
		return insuranceService.getAllInsurance();
	} /// insurance/3545

	@GetMapping("/{insuranceId}")
	public InsuranceDto getInsuranceById(@PathVariable int insuranceId) throws InsuranceIdNotFoundException {
		InsuranceDto i = null;
		i = insuranceService.getInsuranceById(insuranceId); 
		return i;
	}

	@PutMapping
	public InsuranceDto updateInsurance(@RequestBody InsuranceDto insurance) {
		return insuranceService.updateInsurance(insurance);
	}

	@DeleteMapping("/{insuranceId}")
	public String deleteInsuranceById(@PathVariable int insuranceId) {
		return insuranceService.deleteInsuranceById(insuranceId);
	}
}
