package com.analytics.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="brand_analytics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "brand")
    private String brand;

    @Column(name = "post")
    private Long posts;



}
