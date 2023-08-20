package com.example.week5_relationship.Repository;

import com.example.week5_relationship.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<CustomerDetails, Integer> {

    CustomerDetails findCustomerDetailsById(Integer id);
}
