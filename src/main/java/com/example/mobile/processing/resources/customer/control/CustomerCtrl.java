package com.example.mobile.processing.resources.customer.control;

import com.example.mobile.processing.common.RegexLookup;
import com.example.mobile.processing.repositories.customer.entity.Customer;
import com.example.mobile.processing.resources.customer.entity.CustomerModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class CustomerCtrl {
    public CustomerModel getCustomerModel(Customer customer, String country, String countryCode) {
        CustomerModel model = new CustomerModel();
        model.setName(customer.getName());
        model.setPhone(customer.getPhone());
        model.setCountry(country);
        model.setCountryCode(countryCode);
        model.setState(true);
        return model;
    }

    public CustomerModel getCustomerModel(Customer customer) {
        CustomerModel model = new CustomerModel();
        model.setName(customer.getName());
        model.setPhone(customer.getPhone());
        model.setCountry("Unknown");
        model.setCountryCode("Unknown");
        model.setState(false);
        return model;
    }

    public List<CustomerModel> getCustomerList(List<Customer> customerList) {
        List<CustomerModel> modelList = new ArrayList<>();
        customerList.forEach(customer -> {
            boolean found = false;

            /*
                If a regex matches the phone number, then we add it with its corresponding country, code and valid state,
                then break to stop looking for matches

                Note: could have used List.foreach here but a normal iteration would perform better as we could break
                when we find our match, thus reducing the amount of iteration performed
             */
            for (int i = 0; i < RegexLookup.countryCodeList.size(); i++) {
                Pattern p = Pattern.compile(RegexLookup.countryCodeList.get(i).getRegex());
                if (p.matcher(customer.getPhone()).matches()) {
                    modelList.add(getCustomerModel(customer, RegexLookup.countryCodeList.get(i).getName(),
                            RegexLookup.countryCodeList.get(i).getCountryCode()));
                    found = true;
                    break;
                }
            }

            /*
                If no regex matches the phone number, then we add it with unknown country and invalid state
             */
            if (!found) {
                modelList.add(getCustomerModel(customer));
            }
        });
        return modelList;
    }
}
