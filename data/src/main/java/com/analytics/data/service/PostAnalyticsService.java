package com.analytics.data.service;

import com.analytics.data.dto.CarPostDto;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    void saveDataAnalitycs (CarPostDto carPostDto);
}
