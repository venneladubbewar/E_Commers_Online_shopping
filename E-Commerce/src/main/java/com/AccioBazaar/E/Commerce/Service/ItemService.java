package com.AccioBazaar.E.Commerce.Service;

import com.AccioBazaar.E.Commerce.Exception.ProductNotFoundException;
import com.AccioBazaar.E.Commerce.Model.Item;
import com.AccioBazaar.E.Commerce.Model.Product;
import com.AccioBazaar.E.Commerce.Repository.ProductRepository;
import com.AccioBazaar.E.Commerce.ResponseDto.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem (int productId) throws ProductNotFoundException {

        Product product;

        try{
            product = productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Invalid product Id");

        }

        Item item=Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        product.setItem(item);

        productRepository.save(product);

        ItemResponseDto itemResponseDto=ItemResponseDto.builder()
                .price(product.getPrice())
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;

    }
}
