package com.example.week5_relationship.Service;

import com.example.week5_relationship.Api.ApiExeption;
import com.example.week5_relationship.DTO.CustomerDTO;
import com.example.week5_relationship.Model.Customer;
import com.example.week5_relationship.Model.CustomerDetails;
import com.example.week5_relationship.Repository.CustomerRepository;
import com.example.week5_relationship.Repository.DetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;
    public List<CustomerDetails> getAllDetails() {
        return detailsRepository.findAll();
    }

    public void addDetails(CustomerDTO customerDTO){
        Customer customer=customerRepository.findCustomerById(customerDTO.getCustomer_id());
        if (customer==null){
            throw new ApiExeption("ID not Found");
        }

        CustomerDetails customerDetails=new CustomerDetails(null,customerDTO.getGender(),customerDTO.getAge(),
                                                            customerDTO.getEmail(),customer);
        detailsRepository.save(customerDetails);
    }


    public void updateDetails( CustomerDTO customerDTO) {
        CustomerDetails details = detailsRepository.findCustomerDetailsById(customerDTO.getCustomer_id());
        if (details==null) {
           throw new ApiExeption("Detail Not Found");
        }
        details.setGender(customerDTO.getGender());
        details.setAge(customerDTO.getAge());
        details.setEmail(customerDTO.getEmail());
        detailsRepository.save(details);
    }

    public void deleteDetails(Integer detailsId) {
        Customer customer1 = customerRepository.findCustomerById(detailsId);
        CustomerDetails customerDetails1=customer1.getDetails();
        if (customerDetails1 == null) {
            throw new ApiExeption("Detail Not Found");
        }
        detailsRepository.delete(customerDetails1);
    }

}
