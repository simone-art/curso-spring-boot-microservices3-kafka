package com.analytics.data.message;

import com.analytics.data.dto.CarPostDto;
import com.analytics.data.service.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(@Payload CarPostDto carPostDto){
        LOG.info("Received car post information: {}", carPostDto);
        postAnalyticsService.saveDataAnalitycs(carPostDto);
    }
}
