package com.geekster.customermanagement.Repo;

import com.geekster.customermanagement.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IcustomerRepo extends JpaRepository<Customer,String> {
    List<Customer> findByFirstName(String name);

    List<Customer> findByEmail(String email);

    List<Customer> findByCity(String city);

    List<Customer> findByPhone(String phone);
}
