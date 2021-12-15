package com.example.mobile.processing.repositories.customer.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id
    private int id;
    private String name;
    private String phone;
}
