package com.AccioBazaar.E.Commerce.Model;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data   //@data for getter and setter
@Entity
@Builder
@Table(name = "seller")


public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobNo;
    @Column(unique = true)
    private String panNo;


    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)

    List<Product> products = new ArrayList<>();



}
