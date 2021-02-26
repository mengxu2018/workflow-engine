package com.ss.demo.service.impl;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Component
public class TransformationService {

    @Autowired
    private MeterRegistry meterRegistry;

    private List transformationList = new ArrayList<>();;


    @PostConstruct
    public void initialize() {
        System.out.println("transformation service init");
        Gauge.builder("transformation.number", transformationList, Collection::size)
                .description("Number of transformation")
                .register(meterRegistry);
    }

    @Scheduled(fixedRate = 5000)
    public void updateTransformation() throws InterruptedException {
        transformationList.clear();
        System.out.println("updateTransformation called");
        int transformationNumber = getRandomNumber(100, 300);
        for (int i = 0; i < transformationNumber; i++) {
            transformationList.add(i);
        }


    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


    @Scheduled(fixedRate = 5000)
//    @Timed(description = "Time spent serving employee on boarding", longTask = true)
    public void serveEmployee() throws InterruptedException {
            System.out.println("timer called");
    }


}
