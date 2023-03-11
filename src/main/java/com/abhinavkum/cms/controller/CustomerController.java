package com.abhinavkum.cms.controller;


import com.abhinavkum.cms.model.Customer;
import com.abhinavkum.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") int customerId){
        return customerService.getCustomerById(customerId);
    }
    @PutMapping("{customerId}")
    public Customer updateCustomerById(@PathVariable("customerId") int customerId, @RequestBody Customer newCustomerDetails){
       return customerService.updateCustomerById(customerId, newCustomerDetails);
    }
    @DeleteMapping("{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }

}
