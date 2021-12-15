package com.example.mobile.processing.repositories.customer.boundary;

import com.example.mobile.processing.repositories.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
