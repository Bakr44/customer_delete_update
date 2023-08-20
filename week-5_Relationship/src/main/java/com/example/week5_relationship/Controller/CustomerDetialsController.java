package com.example.week5_relationship.Controller;

import com.example.week5_relationship.Api.ApiResponse;
import com.example.week5_relationship.DTO.CustomerDTO;
import com.example.week5_relationship.Model.Customer;
import com.example.week5_relationship.Service.CustomerDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class CustomerDetialsController {

    private final CustomerDetailsService customerDetailsService;

    @GetMapping("/get")
    public ResponseEntity getAllDetails() {
        return ResponseEntity.status(200).body(customerDetailsService.getAllDetails());
    }

    @PostMapping("/add")
    public ResponseEntity addCompany(@RequestBody @Valid CustomerDTO customer) {
        customerDetailsService.addDetails(customer);
        return ResponseEntity.status(200).body(new ApiResponse("Customer added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updateDetails(@RequestBody @Valid CustomerDTO customerDTO) {
         customerDetailsService.updateDetails(customerDTO);
            return ResponseEntity.status(200).body(new ApiResponse("Customer details updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDetails(@PathVariable Integer id) {
        customerDetailsService.deleteDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("Customer details deleted successfully"));
    }
}
