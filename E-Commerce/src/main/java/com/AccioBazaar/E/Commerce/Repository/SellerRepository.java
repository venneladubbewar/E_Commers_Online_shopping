package com.AccioBazaar.E.Commerce.Repository;

import com.AccioBazaar.E.Commerce.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

}
