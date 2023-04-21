package com.AccioBazaar.E.Commerce.Repository;

import com.AccioBazaar.E.Commerce.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

}
