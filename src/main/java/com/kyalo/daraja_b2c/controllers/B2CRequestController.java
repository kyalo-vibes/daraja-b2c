package com.kyalo.daraja_b2c.controllers;

import com.kyalo.daraja_b2c.models.B2CRequest;
import com.kyalo.daraja_b2c.models.TransactionStatusResponse;
import com.kyalo.daraja_b2c.models.UpdateRequest;
import com.kyalo.daraja_b2c.services.B2CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/b2c")
public class B2CRequestController {

    @Autowired
    private B2CService b2cService;

    @PostMapping("/request")
    public ResponseEntity<String> receiveB2CRequest(@RequestBody B2CRequest b2cRequest) {
        b2cService.processB2CRequest(b2cRequest);
        return ResponseEntity.ok("Request received successfully");
    }

    @GetMapping("/status/{transactionId}")
    public ResponseEntity<TransactionStatusResponse> getPaymentStatus(@PathVariable String transactionId) {
        TransactionStatusResponse statusResponse = b2cService.getPaymentStatus(transactionId);
        return ResponseEntity.ok(statusResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePaymentStatus(@RequestBody UpdateRequest updateRequest) {
        b2cService.updatePaymentStatus(updateRequest);
        return ResponseEntity.ok("Status updated successfully");
    }
}
