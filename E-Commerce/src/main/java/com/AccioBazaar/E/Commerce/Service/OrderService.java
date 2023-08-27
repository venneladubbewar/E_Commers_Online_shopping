package com.AccioBazaar.E.Commerce.Service;

import com.AccioBazaar.E.Commerce.Enum.ProductStatus;
import com.AccioBazaar.E.Commerce.Exception.CustomerNotFoundException;
import com.AccioBazaar.E.Commerce.Exception.InsufficientQuantityException;
import com.AccioBazaar.E.Commerce.Exception.ProductNotFoundException;
import com.AccioBazaar.E.Commerce.Model.*;
import com.AccioBazaar.E.Commerce.Repository.CustomerRepository;
import com.AccioBazaar.E.Commerce.Repository.ItemRepository;
import com.AccioBazaar.E.Commerce.Repository.OrderedRepository;
import com.AccioBazaar.E.Commerce.Repository.ProductRepository;
import com.AccioBazaar.E.Commerce.RequestDto.OrderRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.ItemResponseDto;
import com.AccioBazaar.E.Commerce.ResponseDto.OrderResponseDto;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@Service
public class OrderService {


    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;


    @Autowired
    ItemRepository itemRepository;

    public OrderResponseDto addOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantityException, HibernateException {
        System.out.println("kiran");
        Customer customer;
        try {
            customer= customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }catch (Exception e){
            throw new CustomerNotFoundException("Invalid CustomerId...");
        }
        System.out.println("kiran2");
        Product product;

        try{
            System.out.println("kiran3");
            product=productRepository.findById(orderRequestDto.getProductId()).get();
            System.out.println("kiran4");
        }catch (Exception e){
            throw new ProductNotFoundException("Invalid product id.9090..");
        }




        System.out.println(product.getProductName()+"================"+customer.getName());
        System.out.println("kiran5");


        if(orderRequestDto.getQuantity()>product.getQuantity()){
            throw new InsufficientQuantityException("Quantity insufficient...");
       }
        else{
            product.setQuantity(product.getQuantity()-orderRequestDto.getQuantity());
            if(product.getQuantity()==0)
            {
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
               // throw new InsufficientQuantityException("Out_Of_stock");
            }

        }


        int deliveryCharges=0;
        int totalCost= product.getPrice() * orderRequestDto.getQuantity();
        if(totalCost<500){
            deliveryCharges=50;
            totalCost+=50;
        }

       Ordered order = new Ordered();
        order.setTotalCost(totalCost);
        order.setDeliveryCharge(deliveryCharges);
        order.setCustomer(customer);

        Card card=customer.getCards().get(0);
        int n = card.getCardNo().length();

        String cardUsed="";
        for(int i=0; i<n-4-1; i++){
            cardUsed+="X";
        }
        cardUsed+=card.getCardNo().substring(n-4);

        order.setCardUsedForPayment(cardUsed);



        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getQuantity());
        item.setProduct(product);
        item.setOrdered(order);
        order.getOrderedItems().add(item);

        //Adding this order into Customers order's list
        customer.getOrders().add(order);


        Customer savedCustomer = customerRepository.save(customer);
        Ordered savedOrder = savedCustomer.getOrders().get(savedCustomer.getOrders().size()-1);



        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .itemName(product.getProductName())
                .orderDate(savedOrder.getOrderDate())
                .quantity(orderRequestDto.getQuantity())
                .cardUsedForPayment(cardUsed)
                .itemCost(product.getPrice())
                .totalCost(order.getTotalCost())
                .deliveryCost(deliveryCharges)
                .build();

        return orderResponseDto;


    }
}

































//
//
//public class OrderService {
//
//    @Autowired
//    CustomerRepository customerRepository;
//    @Autowired
//    ProductRepository productRepository;
//
// //   @Autowired
//    //JavaMailSender emailSender;
//
//    public OrderResponseDto addOrder(OrderRequestDto orderRequestDto) throws Exception {
//        Customer customer;
//        try{
//            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
//        }
//        catch(Exception e){
//            throw new CustomerNotFoundException("Invalid Customer id !!!");
//        }
//
//        Product product;
//        try{
//            product = productRepository.findById(orderRequestDto.getProductId()).get();
//        }
//        catch (Exception e){
//            throw new ProductNotFoundException("Invalid Product Id");
//        }
//
//        if(product.getQuantity()<orderRequestDto.getQuantity()){
//            throw new Exception("Sorry! Required quantity not available");
//        }
//
//        Ordered order = new Ordered();
//        order.setTotalCost(orderRequestDto.getQuantity()* product.getPrice());
//        order.setDeliveryCharge(40);
//        Card card = customer.getCards().get(0);
//        String cardNo = "";
//        for(int i=0;i<card.getCardNo().length()-4;i++)
//            cardNo += 'X';
//        cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
//        order.setCardUsedForPayment(cardNo);
//
//        Item item = new Item();
//        item.setRequiredQuantity(orderRequestDto.getQuantity());
//        item.setProduct(product);
//        item.setOrdered(order);
//        order.getOrderedItems().add(item);
//        order.setCustomer(customer);
//
//        int leftQuantity = product.getQuantity()-orderRequestDto.getQuantity();
//        if(leftQuantity<=0)
//            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
//        product.setQuantity(leftQuantity);
//
//        customer.getOrders().add(order);
//        Customer savedCustomer = customerRepository.save(customer);
//        Ordered savedOrder = savedCustomer.getOrders().get(savedCustomer.getOrders().size()-1);
//
//        //prepare response DTO
//        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
//                .itemName(product.getProductName())
//                .orderDate(savedOrder.getOrderDate())
//                .quantity(orderRequestDto.getQuantity())
//                .cardUsedForPayment(cardNo)
//                .itemCost(product.getPrice())
//                .totalCost(order.getTotalCost())
//                .deliveryCost(40)
//                .build();
//
//        // send an email
//       // String text = "Congrats your order with total value "+order.getTotalCost()+" has been placed";
//
//
//        return orderResponseDto;
//    }
//}