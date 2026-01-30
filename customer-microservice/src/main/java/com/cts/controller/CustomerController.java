package com.cts.controller;

import com.cts.dto.ApiResponse;
import com.cts.dto.UpdateCustomerRequest;
import com.cts.entity.Customer;
import com.cts.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:5173" })
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCustomerByUserId(@PathVariable String userId) {
        try {
            Customer customer = customerService.getCustomerByUserId(userId);
            return ResponseEntity.ok(customer);
        } catch (IllegalArgumentException ex) {
            ApiResponse resp = new ApiResponse("error", ex.getMessage());
            return ResponseEntity.badRequest().body(resp);
        } catch (Exception ex) {
            ApiResponse resp = new ApiResponse("error", "Failed to fetch customer information");
            return ResponseEntity.internalServerError().body(resp);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateCustomer(
            @PathVariable String userId,
            @Valid @RequestBody UpdateCustomerRequest request) {
        try {
            Customer updated = customerService.updateCustomer(userId, request);
            ApiResponse resp = new ApiResponse("success", "Customer information updated successfully", updated.getId());
            return ResponseEntity.ok(resp);
        } catch (IllegalArgumentException ex) {
            ApiResponse resp = new ApiResponse("error", ex.getMessage());
            return ResponseEntity.badRequest().body(resp);
        } catch (Exception ex) {
            ApiResponse resp = new ApiResponse("error", "Failed to update customer information");
            return ResponseEntity.internalServerError().body(resp);
        }
    }
}
