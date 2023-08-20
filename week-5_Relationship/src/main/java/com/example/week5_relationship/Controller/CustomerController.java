package com.example.week5_relationship.Controller;

import com.example.week5_relationship.Api.ApiResponse;
import com.example.week5_relationship.Model.Customer;
import com.example.week5_relationship.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity getAllCompanies() {
        return ResponseEntity.status(200).body(customerService.getAllCustomer());
    }


    @PostMapping("/add")
    public ResponseEntity addCompany(@RequestBody @Valid Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("Customer added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCompany(@PathVariable Integer id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body(new ApiResponse("Customer updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCompany(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("Customer deleted successfully"));
    }

}
