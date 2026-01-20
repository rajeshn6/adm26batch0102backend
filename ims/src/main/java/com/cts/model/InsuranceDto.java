package com.cts.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDto {
		private int id;
		@NotBlank(message = "Insurance plan name is mandatory")
		private String planName;
		@PositiveOrZero(message = "Insurance premium amount should be positive number")
		private int premium;
		@Positive
		private int tenure;	
		@Email
		private String email;
		@FutureOrPresent
		private LocalDate date;
		
}
