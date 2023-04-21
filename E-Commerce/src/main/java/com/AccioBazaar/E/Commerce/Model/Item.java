package com.AccioBazaar.E.Commerce.Model;


import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data   //@data for getter and setter
@Entity
@Builder
@Table(name = "item")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int requiredQuantity;

    @ManyToOne
    @JoinColumn
    Cart cart;

    @ManyToOne
    @JoinColumn
    Ordered ordered;

    @OneToOne
    @JoinColumn
    Product product;
}
