package com.AccioBazaar.E.Commerce.Repository;

import com.AccioBazaar.E.Commerce.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
