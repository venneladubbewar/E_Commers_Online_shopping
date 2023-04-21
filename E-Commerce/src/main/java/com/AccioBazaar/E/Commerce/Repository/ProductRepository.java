package com.AccioBazaar.E.Commerce.Repository;

import com.AccioBazaar.E.Commerce.Enum.ProductCategory;
import com.AccioBazaar.E.Commerce.Model.Product;
import com.AccioBazaar.E.Commerce.ResponseDto.ProductResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByProductCategory(ProductCategory productCategory);
}
