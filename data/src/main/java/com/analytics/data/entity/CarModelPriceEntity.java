package com.analytics.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="car_model_price")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;
}
