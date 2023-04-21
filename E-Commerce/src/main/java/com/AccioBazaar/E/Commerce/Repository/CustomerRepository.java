package com.AccioBazaar.E.Commerce.Repository;

import com.AccioBazaar.E.Commerce.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
