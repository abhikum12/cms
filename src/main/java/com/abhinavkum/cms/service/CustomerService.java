package com.abhinavkum.cms.service;

import com.abhinavkum.cms.dao.CustomerDAO;
import com.abhinavkum.cms.exception.CustomerNotFoundException;
import com.abhinavkum.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
        customerDAO.save(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
//        return customerList;
    }

    public Customer getCustomerById (int customerId){

       Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
       if(!optionalCustomer.isPresent())
           throw new CustomerNotFoundException("Customer Record is not available!");
       return optionalCustomer.get();
//        return customerDAO.findById(customerId).get();
//        return customerList.stream().filter(customer -> customer.getCustomerId() == customerId).findFirst().get();

    }

    public Customer updateCustomerById(int customerId, Customer updatedCustomer){

        updatedCustomer.setCustomerId(customerId);
        return customerDAO.save(updatedCustomer);

//         customerList
//                 .stream()
//                 .forEach(customer ->
//                 {if(customer.getCustomerId() == customerId){
//                    customer.setCustomerFirstName(updatedCustomer.getCustomerFirstName());
//                    customer.setCustomerEmail(updatedCustomer.getCustomerEmail());
//                    customer.setCustomerLastName(updatedCustomer.getCustomerLastName());
//                 }
//                });
//        return customerList
//                    .stream()
//                    .filter(customer -> customer.getCustomerId() == customerId).findFirst().get();
    }

    public void deleteCustomer(int customerId){

        customerDAO.deleteById(customerId);
//        customerList
//                .stream()
//                .forEach(customer ->
//        {
//            if(customer.getCustomerId() == customerId){
//                customerList.remove(customer);
//            }
//        });

    }

}
