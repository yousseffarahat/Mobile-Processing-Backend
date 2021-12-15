package com.example.mobile.processing.integration.customer;

import com.example.mobile.processing.integration.BaseIntegrationTest;
import com.example.mobile.processing.resources.customer.entity.CustomerModel;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerResourceIT extends BaseIntegrationTest {
    public static String CUSTOMER_URI = "/customers/";

    @Test
    public void shouldReturnAllCustomer() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(CUSTOMER_URI))
                .andExpect(status().isOk()).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        assertEquals(mockHttpServletResponse.getStatus(), 200);

        CustomerModel[] customerModels =mapFromJson(mockHttpServletResponse.getContentAsString(), CustomerModel[].class);

        assertTrue(customerModels.length>0);
    }
}
