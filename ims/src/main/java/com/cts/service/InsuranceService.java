package com.cts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.entity.Insurance;
import com.cts.exception.InsuranceIdNotFoundException;
import com.cts.model.InsuranceDto;
import com.cts.repository.InsuranceRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InsuranceService {

	@Autowired
	private InsuranceRespository insuranceRespository;
	

	// send this insurance model object to insurance repository
	// jpa save(insurance)
	public InsuranceDto createInsurance(InsuranceDto insurance) {
		log.info("the service is recieved insurance dto object");
		ModelMapper modelMapper=new ModelMapper();
		Insurance insurance1=modelMapper.map(insurance, Insurance.class);
		log.info(" insurance dto object to entity");
		Insurance i=insuranceRespository.save(insurance1); // insert query
		log.info("insurance object is got persisted in db success");
		InsuranceDto ins=modelMapper.map(i, InsuranceDto.class);
		return ins;
	}

	public List<InsuranceDto> getAllInsurance() {
		List<Insurance> list=insuranceRespository.findAll();
		ModelMapper modelMapper=new ModelMapper();
		List<InsuranceDto> insuranceList=list.stream()
			.map(e->modelMapper.map(e, InsuranceDto.class))
			.collect(Collectors.toList());
		return insuranceList; // select * from insurance;
	}

	public InsuranceDto getInsuranceById(int insuranceId) throws InsuranceIdNotFoundException  {
		ModelMapper modelMapper=new ModelMapper();
		
		Optional<Insurance> optionalInsurance=insuranceRespository.findById(insuranceId);
		if(optionalInsurance.isEmpty())
		{
			throw new InsuranceIdNotFoundException("Insurance is not exists in the db!! check the insurance ID");
			
		}
		return modelMapper.map(optionalInsurance.get(),InsuranceDto.class);
	}
	public InsuranceDto updateInsurance(InsuranceDto insurance) { // 1
		ModelMapper modelMapper=new ModelMapper();
		
		Insurance i = insuranceRespository.save
				(modelMapper.map(insurance, Insurance.class)); 
		return modelMapper.map(i, InsuranceDto.class);
	}
	public String deleteInsuranceById(int insuranceId) {
		Optional<Insurance> optionalInsurance=insuranceRespository.findById(insuranceId);
		if(optionalInsurance.isEmpty()) {
			return "Failed to delete insurance plan!!! insurance id: "+insuranceId +" is not found";
		}
		insuranceRespository.delete(optionalInsurance.get());
		return "deleted insurance plan!!! with insurance id: "+insuranceId +" success";
	}
}










