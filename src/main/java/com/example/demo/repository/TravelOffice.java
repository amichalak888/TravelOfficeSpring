package com.example.demo.repository;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.Trip;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class TravelOffice {

  Map <Long, Customer> customerMap = new HashMap<>();
    {
        customerMap.put(1L, new Customer(1L, "Ola"));
        customerMap.put(2L, new Customer(2L, "Ela"));
        customerMap.put(3L, new Customer(3L, "Ala"));
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    public Map<Long, Customer> getCustomerMap() {
        return customerMap;
    }

    void removeCustomer(Customer customer) {
        customerMap.remove(customer.getId());
    }


}

