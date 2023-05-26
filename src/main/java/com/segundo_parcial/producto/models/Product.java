package com.segundo_parcial.producto.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String title;
    private float price;
    @Column(length = 1000)
    private String description;
    private String image;
    private String category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
