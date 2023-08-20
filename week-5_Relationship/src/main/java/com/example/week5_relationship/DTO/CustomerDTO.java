package com.example.week5_relationship.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    private Integer customer_id;

    private String gender;
    private String age;
    private String email;
}
