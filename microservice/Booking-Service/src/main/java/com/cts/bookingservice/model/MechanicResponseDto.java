package com.cts.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicResponseDto {
	private Integer mechanicId;
	private Integer serviceCenterId;
	private String name;
	private String expertise;
	private String email;
}
