package com.example.mobile.processing.unit.customer;

import com.example.mobile.processing.repositories.customer.entity.Customer;
import com.example.mobile.processing.resources.customer.control.CustomerCtrl;
import com.example.mobile.processing.resources.customer.entity.CustomerModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerCtrlTest {
    @Autowired
    private CustomerCtrl customerCtrl;

    @Test
    void shouldReturnACustomerWithAnInvalidState(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(256) 7771031454");
        CustomerModel model = customerCtrl.getCustomerModel(customer);

        assertEquals(customer.getPhone(),model.getPhone());
        assertEquals(customer.getName(),model.getName());
        assertEquals("Unknown",model.getCountry());
        assertEquals("Unknown",model.getCountryCode());
        assertFalse(model.isState());
    }

    @Test
    void shouldReturnACustomerWithACountryAndCountryCode(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(256) 714660221");
        CustomerModel model = customerCtrl.getCustomerModel(customer,"Uganda","+256");

        assertEquals(customer.getPhone(),model.getPhone());
        assertEquals(customer.getName(),model.getName());
        assertEquals("Uganda",model.getCountry());
        assertEquals("+256",model.getCountryCode());
        assertTrue(model.isState());
    }

    @Test
    void shouldReturnCameroonianCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(237) 677046616");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        List<CustomerModel> modelList = customerCtrl.getCustomerList(customerList);
        assertEquals("Cameroon", modelList.get(0).getCountry());
        assertEquals("+237", modelList.get(0).getCountryCode());
    }

    @Test
    void shouldReturnEthiopianCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(251) 914701723");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        List<CustomerModel> modelList = customerCtrl.getCustomerList(customerList);
        assertEquals("Ethiopia", modelList.get(0).getCountry());
        assertEquals("+251", modelList.get(0).getCountryCode());
    }

    @Test
    void shouldReturnMoroccanCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(212) 698054317");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        List<CustomerModel> modelList = customerCtrl.getCustomerList(customerList);
        assertEquals("Morocco", modelList.get(0).getCountry());
        assertEquals("+212", modelList.get(0).getCountryCode());
    }

    @Test
    void shouldReturnMozambiqueCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(258) 847602609");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        List<CustomerModel> modelList = customerCtrl.getCustomerList(customerList);
        assertEquals("Mozambique", modelList.get(0).getCountry());
        assertEquals("+258", modelList.get(0).getCountryCode());
    }

    @Test
    void shouldReturnUgandanCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(256) 714660221");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        List<CustomerModel> modelList = customerCtrl.getCustomerList(customerList);
        assertEquals("Uganda", modelList.get(0).getCountry());
        assertEquals("+256", modelList.get(0).getCountryCode());
    }

    @Test
    void shouldReturnUnknownCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Name");
        customer.setPhone("(2526) 7146602221");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        List<CustomerModel> modelList = customerCtrl.getCustomerList(customerList);
        assertEquals("Unknown", modelList.get(0).getCountry());
        assertEquals("Unknown", modelList.get(0).getCountryCode());
    }


}
