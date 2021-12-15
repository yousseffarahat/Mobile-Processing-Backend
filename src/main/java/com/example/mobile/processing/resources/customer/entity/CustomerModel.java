package com.example.mobile.processing.resources.customer.entity;

import lombok.Data;

@Data
public class CustomerModel {
    private String name;
    private String phone;
    private String country;
    private String countryCode;
    private boolean state;
}
