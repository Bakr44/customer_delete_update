package com.example.week5_relationship.Service;

import com.example.week5_relationship.Api.ApiExeption;
import com.example.week5_relationship.Model.Customer;
import com.example.week5_relationship.Repository.CustomerRepository;
import com.example.week5_relationship.Repository.DetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;


    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

//    public Customer getCompanyById(Integer id) {
//        return companyRepository.findCompaniesById(id);
//    }

    public void addCustomer(Customer customer) {
         customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer) {
        Customer customer1 = customerRepository.findCustomerById(id);
        if (customer1==null) {
            throw new ApiExeption("ID Not Found");
        }
        customer1.setName(customer.getName());
        customerRepository.save(customer1);
    }

    public void deleteCustomer(Integer id) {
        Customer customer1 = customerRepository.findCustomerById(id);
        if (customer1==null) {
            throw new ApiExeption("ID Not Found");
        }
detailsRepository.deleteById(id);
    customerRepository.delete(customer1);

    }



}
