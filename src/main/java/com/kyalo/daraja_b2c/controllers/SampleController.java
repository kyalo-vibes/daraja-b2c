package com.kyalo.daraja_b2c.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    // sample REST API to test application is running properly
    @GetMapping(produces = "application/json")
    public String getSample() {
        return "Hello, Tanda Africa!";
    }

}
