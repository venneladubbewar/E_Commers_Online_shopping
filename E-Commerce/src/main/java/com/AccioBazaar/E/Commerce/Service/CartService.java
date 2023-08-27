package com.AccioBazaar.E.Commerce.Service;

import com.AccioBazaar.E.Commerce.Enum.ProductStatus;
import com.AccioBazaar.E.Commerce.Exception.CustomerNotFoundException;
import com.AccioBazaar.E.Commerce.Exception.ProductNotFoundException;
import com.AccioBazaar.E.Commerce.Model.*;
import com.AccioBazaar.E.Commerce.Repository.CartRepository;
import com.AccioBazaar.E.Commerce.Repository.CustomerRepository;
import com.AccioBazaar.E.Commerce.Repository.ProductRepository;
import com.AccioBazaar.E.Commerce.RequestDto.OrderRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    public String addItemTocart(OrderRequestDto orderRequestDto) throws Exception {

        Customer customer;


        try{
            customer=customerRepository.findById(orderRequestDto.getCustomerId()).get();

        }catch (Exception e){
            throw new CustomerNotFoundException("Customer not fount in cart..#####.");
        }

        Product product;
        try{
            product= productRepository.findById(orderRequestDto.getProductId()).get();
        }catch (Exception e){
            throw new ProductNotFoundException("Product not found in cart....");
        }

        if(orderRequestDto.getQuantity()>product.getQuantity()){
            throw new Exception("Sorry! Required quantity not available");
        }else {
            product.setQuantity(product.getQuantity() - orderRequestDto.getQuantity());
            if(product.getQuantity()<=0) product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }


        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal() + (product.getPrice() * orderRequestDto.getQuantity()));

        Item item = new Item();
        item.setCart(cart);
        item.setId(product.getId());
        item.setRequiredQuantity(orderRequestDto.getQuantity());
        item.setProduct(product);

        cart.getItems().add(item);
        customerRepository.save(customer);
        return "Item added into cart ";

    }

    public List<OrderResponseDto> checkout(int customerId) throws CustomerNotFoundException {
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        Customer customer;
        try{
            customer=customerRepository.findById(customerId).get();
        }catch (Exception e){
            throw new CustomerNotFoundException("No Customer inCart ");
        }
        Cart cart = customer.getCart();
        List<Item> itemList=cart.getItems();
        for(Item i: itemList){
           Ordered order = new Ordered();
           int deliveryCharges=0;
           int totalcost=i.getRequiredQuantity()*i.getProduct().getPrice();
           if(totalcost<500)
           {
               deliveryCharges=50;
               totalcost+=deliveryCharges;
           }
           Card card=customer.getCards().get(0);
           String cardUsed="";
           int n=card.getCardNo().length();
           for(int k=0; k<n-4; k++){
               cardUsed+='X';
           }
           cardUsed+=card.getCardNo().substring(n-4);
           order.setDeliveryCharge(deliveryCharges);
           order.setTotalCost(totalcost);
           order.setCustomer(customer);
           order.setCardUsedForPayment(cardUsed);

          int leftItems= i.getProduct().getQuantity()-i.getRequiredQuantity();
          if(leftItems<=0){
              i.getProduct().setProductStatus(ProductStatus.OUT_OF_STOCK);
          }
          i.getProduct().setQuantity(leftItems);

          customer.getOrders().add(order);

         OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                 .orderDate(order.getOrderDate())
                 .itemName(i.getProduct().getProductName())
                 .quantity(i.getRequiredQuantity())
                 .itemCost(i.getProduct().getPrice())
                 .deliveryCost(deliveryCharges)
                 .totalCost(totalcost)
                 .cardUsedForPayment(cardUsed)
                 .build();

         orderResponseDtos.add(orderResponseDto);


        }
        cart.setCartTotal(0);
        cart.setItems(new ArrayList<>());
        customerRepository.save(customer);

        return orderResponseDtos;

    }
}
