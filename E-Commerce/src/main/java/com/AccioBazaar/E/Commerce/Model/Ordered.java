package com.AccioBazaar.E.Commerce.Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data   //@data for getter and setter
@Entity
@Builder
@Table(name = "orders")

public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date orderDate;

    private int totalCost;

    private int deliveryCharge;

    private String cardUsedForPayment;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany (mappedBy = "ordered", cascade = CascadeType.ALL)
    List<Item> orderedItems = new ArrayList<>();

}
