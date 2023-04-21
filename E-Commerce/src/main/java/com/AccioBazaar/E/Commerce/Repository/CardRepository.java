package com.AccioBazaar.E.Commerce.Repository;

import com.AccioBazaar.E.Commerce.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

}
