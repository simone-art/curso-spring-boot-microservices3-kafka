package com.analytics.data.service;

import com.analytics.data.dto.CarPostDto;
import com.analytics.data.entity.BrandAnalyticsEntity;
import com.analytics.data.entity.CarModelAnalyticsEntity;
import com.analytics.data.entity.CarModelPriceEntity;
import com.analytics.data.repository.BrandAnalyticsRepository;
import com.analytics.data.repository.CarModelAnalyticsRepository;
import com.analytics.data.repository.CarModelPriceRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService{

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarModelPriceRepository carModelPriceRepository;

    // Método que chama outros tres métodos privados que fazem cálculos específicos
    @Override
    public void saveDataAnalitycs(CarPostDto carPostDto) {
        saveBrandDataAnalitycs(carPostDto.getBrand());
        saveCarModelAnalitycs(carPostDto.getModel());
        saveCarModelAndPriceAnalitycs(carPostDto.getModel(), carPostDto.getPrice());

    }
    
    private void saveBrandDataAnalitycs(String brand) {

        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();
        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item->{
            item.setPosts(item.getPosts()+ 1);
            brandAnalyticsRepository.save(item);
        }, ()->{
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });

    }

    private void saveCarModelAnalitycs(String model) {

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();
        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item->{
            item.setPosts(item.getPosts()+ 1);
            carModelAnalyticsRepository.save(item);
        }, ()->{
            carModelAnalyticsEntity.setModel(model);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });

    }

    private void saveCarModelAndPriceAnalitycs(String model, Double price) {

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(model);
        carModelPriceEntity.setPrice(price);

        carModelPriceRepository.save(carModelPriceEntity);
    }


}
