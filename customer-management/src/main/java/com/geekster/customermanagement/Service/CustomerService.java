package com.geekster.customermanagement.Service;

import com.geekster.customermanagement.Model.Customer;
import com.geekster.customermanagement.Repo.IcustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private IcustomerRepo customerRepo;

    public void createCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerId(String id) {
        return customerRepo.findById(id).orElseThrow();
    }

    public Boolean updateCustomer(Customer customer) {
        Customer currentCustomer=customerRepo.findById(customer.getUuid()).orElseThrow();
        customerRepo.save(customer);
        return true;
    }

    public void deletCustomerById(String id) {
        customerRepo.delete(customerRepo.findById(id).orElseThrow());
    }

    public List<Customer> getAllByPage(Integer pageNo, Integer pageSize) {
        Pageable paging= (Pageable) PageRequest.of(pageNo,pageSize);
        Page<Customer> customerPage=customerRepo.findAll((org.springframework.data.domain.Pageable) paging);
        if(customerPage.hasContent())return customerPage.getContent();
        return new ArrayList<>();
    }

    public List<Customer> getByName(String name) {
        return customerRepo.findByFirstName(name);
    }

    public List<Customer> getByEmail(String email) {
        return customerRepo.findByEmail(email);
    }

    public List<Customer> getByCity(String city) {
        return customerRepo.findByCity(city);
    }

    public List<Customer> getByPhone(String phone) {
        return customerRepo.findByPhone(phone);
    }
}

