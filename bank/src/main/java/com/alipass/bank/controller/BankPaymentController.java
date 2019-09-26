package com.alipass.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by adere on 25.09.2019.
 */
@RestController
public class BankPaymentController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @GetMapping(value = "/bank/three3DAuth/{id}")
    public String three3DAuth(@PathVariable String id) throws InterruptedException {

        logger.info("3D auth started for id" + id);

        Thread.sleep(5000);

        logger.info("3D auth finished for id ");

        return "3D Access granted for " + id;
    }

}
