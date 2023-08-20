package com.example.week5_relationship.Repository;

import com.example.week5_relationship.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findCustomerById(Integer id);

}
