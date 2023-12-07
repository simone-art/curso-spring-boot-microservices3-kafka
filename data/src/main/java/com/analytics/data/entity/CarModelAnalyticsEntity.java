package com.analytics.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="car_model_analytics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "model")
    private String model;

    @Column(name = "posts")
    private Long posts;

}
