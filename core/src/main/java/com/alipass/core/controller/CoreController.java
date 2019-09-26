package com.alipass.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * Created by adere on 26.09.2019.
 */
@RestController
public class CoreController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping(value = "/alipass/3dNonBlocking/{id}")
    public Flux<String> call3dNonBlocking(@PathVariable String id) {

        /*
        ExchangeFilterFunction filterFunction = (clientRequest, nextFilter) -> {
            logger.info("WebClient fitler executed thread id " + Thread.currentThread().getId());
            return nextFilter.exchange(clientRequest);
        };*/

        logger.info("3D Flux for id started " + id + " thread name: " + Thread.currentThread().getName());




        Flux<String> threeDResponse = WebClient.create()
                .get()
                .uri("localhost:9898/bank/three3DAuth/" + id)
                .retrieve()
                .bodyToFlux(String.class).log();




        /*
        WebClient webClient = WebClient.builder().filter(filterFunction).build();
        Flux<String> threeDResponse = webClient
                .get()
                .uri("localhost:9898/bank/three3DAuth/" + id)
                .retrieve()
                .bodyToFlux(String.class).log();
                */

        //threeDResponse.subscribe(response -> logger.info(response));

        logger.info("3D Flux finished for id " + id + " thread name: "+ Thread.currentThread().getName());

        return threeDResponse;


    }
}
