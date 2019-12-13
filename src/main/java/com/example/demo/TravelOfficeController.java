package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.repository.TravelOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Map;

@RestController
@SpringBootApplication
@EnableSwagger2

public class TravelOfficeController {

    @Autowired
    TravelOfficeRepository travelOffice;

    @GetMapping("/customerList")
    public Map customerList() {
        return travelOffice.getCustomerMap();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        travelOffice.addCustomer(customer);
        return customer;
    }
}






