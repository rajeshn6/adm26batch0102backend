package com.cts.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
	//http://localhost:8080/booking-api/bookings/status/678
	
	@Bean
	
	RouteLocator routes(RouteLocatorBuilder builder) {
	return builder.routes()
	.route("USER-SERVICE",
			r -> r.path("/user-api/**").uri("lb://USER-SERVICE"))
	.route("MECHANIC-SERVICE",
			r -> r.path("/mechanic-api/**").uri("lb://MECHANIC-SERVICE"))
	.route("BOOKING-SERVICE",
			r -> r.path("/booking-api/**").uri("lb://BOOKING-SERVICE"))
	.build();
	}

}
