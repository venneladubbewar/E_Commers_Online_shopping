package com.AccioBazaar.E.Commerce.Service;

import com.AccioBazaar.E.Commerce.Convertor.ProductConvertor;
import com.AccioBazaar.E.Commerce.Enum.ProductCategory;
import com.AccioBazaar.E.Commerce.Exception.SellerNotPresentException;
import com.AccioBazaar.E.Commerce.Model.Product;
import com.AccioBazaar.E.Commerce.Model.Seller;
import com.AccioBazaar.E.Commerce.Repository.ProductRepository;
import com.AccioBazaar.E.Commerce.Repository.SellerRepository;
import com.AccioBazaar.E.Commerce.RequestDto.ProductRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotPresentException {

        Seller seller;

        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e) {

            throw new SellerNotPresentException("Invalid seller Id");
        }

        Product product= ProductConvertor.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

        sellerRepository.save(seller);

        ProductResponseDto productResponseDto =ProductConvertor.productToProductResponseDto(product);

        return productResponseDto;



    }

    public List<ProductResponseDto> getAllProductsByCategory(ProductCategory productCategory) {

        List<Product> products=productRepository.findAllByProductCategory(productCategory);

        List<ProductResponseDto> productResponseDtos=new ArrayList<>();

        for(Product product:products){
            ProductResponseDto productResponseDto=ProductConvertor.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}
