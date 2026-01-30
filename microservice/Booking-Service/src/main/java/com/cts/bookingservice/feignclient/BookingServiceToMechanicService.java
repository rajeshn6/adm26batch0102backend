package com.cts.bookingservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.bookingservice.model.MechanicResponseDto;

@FeignClient(name = "MECHANIC-SERVICE")
public interface BookingServiceToMechanicService {
	@GetMapping("/mechanic-api/mechanics/{mechanicId}")
	public MechanicResponseDto mechanicById(@PathVariable int mechanicId);
}
