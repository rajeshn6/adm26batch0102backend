package com.cts.bookingservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="USER-SERVICE")
public interface BookingServiceToUserService {
	@GetMapping("/user-api/users/{email}")
	public String getUser(@PathVariable String email);

}
