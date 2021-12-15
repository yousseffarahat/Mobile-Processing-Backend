package com.example.mobile.processing.resources.customer.boundary;

import com.example.mobile.processing.repositories.customer.boundary.CustomerRepository;
import com.example.mobile.processing.repositories.customer.entity.Customer;
import com.example.mobile.processing.resources.customer.control.CustomerCtrl;
import com.example.mobile.processing.resources.customer.entity.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerResource {
    private final CustomerRepository customerRepository;
    private final CustomerCtrl customerCtrl;

    @Autowired
    public CustomerResource(CustomerRepository customerRepository, CustomerCtrl customerCtrl) {
        this.customerRepository = customerRepository;
        this.customerCtrl = customerCtrl;
    }
    @GetMapping("/")
    public ResponseEntity<List<CustomerModel>> getAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        return ResponseEntity.ok(customerCtrl.getCustomerList(customerList));
    }
}
