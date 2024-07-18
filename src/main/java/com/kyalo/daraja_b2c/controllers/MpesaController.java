package com.kyalo.daraja_b2c.controllers;

import com.kyalo.daraja_b2c.dtos.AccessTokenResponse;
import com.kyalo.daraja_b2c.services.DarajaApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mobile-money")
public class MpesaController {

    private final DarajaApi darajaApi;

    public MpesaController(DarajaApi darajaApi) {this.darajaApi = darajaApi;}

    @GetMapping(path = "/token", produces = "application/json")
    public ResponseEntity<AccessTokenResponse> getAccessToken() {
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }
}
