package com.AccioBazaar.E.Commerce.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data   //@data for getter and setter
@Entity
@Table(name = "cart")

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cartTotal;

    @OneToOne
    @JoinColumn
    Customer customer;

    @OneToMany (mappedBy = "cart", cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();




}
