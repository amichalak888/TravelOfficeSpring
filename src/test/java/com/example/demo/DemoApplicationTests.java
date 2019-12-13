package com.example.demo;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.MyDate;
import com.example.demo.model.Trip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldShowList() throws Exception {
        this.mockMvc.perform(get("/customerList"))
                .andExpect((status().isOk()));
    }
@Autowired
    @Test
    public void shouldcreateCustomer () throws Exception {
        Customer createdCustomer = createCustomer();
        assertThat (createdCustomer.getId()).isNotNull();

    }
    private Customer createCustomer () throws  Exception {
        Customer customer = new Customer();
        customer.setName("Igor");
        customer.setId(1L);
        customer.setAddress(new Address("Sezamkowa","62-510","KOnin"));
        customer.setTrip(new Trip(new MyDate(2019,12,1),new MyDate(2019,12,24),"Malta",8888));

        String postValue = OBJECT_MAPPER.writeValueAsString(customer);

        MvcResult jaksResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/addCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        return OBJECT_MAPPER.readValue(jaksResult.getResponse().getContentAsString(),Customer.class);
    }
    @Test
    public void shouldNot () throws Exception {
        Customer createdCustomer = createCustomer();
        assertThat (createdCustomer.getId()).isNotNull();

    }
    private Customer createCustomer1 () throws  Exception {
        Customer customer = new Customer();
        customer.setName("Igor");
        customer.setId(1L);
        customer.setAddress(new Address("Sezamkowa","62-510","KOnin"));
        customer.setTrip(new Trip(new MyDate(2019,12,1),new MyDate(2019,12,24),"Malta",8888));

        String postValue = OBJECT_MAPPER.writeValueAsString(customer);

        MvcResult jaksResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/addCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        return OBJECT_MAPPER.readValue(jaksResult.getResponse().getContentAsString(),Customer.class);
}}
