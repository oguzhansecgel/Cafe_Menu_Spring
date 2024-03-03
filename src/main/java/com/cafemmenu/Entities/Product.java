package com.cafemmenu.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.text.DecimalFormat;

@Entity
@Data
@Table(name = "Urunler")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
    private Double price;
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    @ManyToOne
    private Category category;
}
