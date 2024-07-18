package com.kyalo.daraja_b2c.consumer;

import com.google.gson.Gson;
import com.kyalo.daraja_b2c.models.B2CResponse;
import com.kyalo.daraja_b2c.models.Transaction;
import com.kyalo.daraja_b2c.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class B2CResponseConsumer {
    @Autowired
    private TransactionRepository transactionRepository;

    @KafkaListener(topics = "b2c-responses", groupId = "b2c-group")
    public void consumeB2CResponse(String message) {
        B2CResponse response = deserializeResponse(message);
        Transaction transaction = transactionRepository.findById(response.getId())
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setTransStatus(response.getStatus());
        transaction.setExternalOrderId(response.getExternalOrderId());
        transaction.setErrorCode(response.getErrorCode());
        transaction.setErrorDesc(response.getErrorDesc());
        transactionRepository.save(transaction);
    }

    private B2CResponse deserializeResponse(String message) {
        // Deserialize JSON string to B2CResponse object
        return new Gson().fromJson(message, B2CResponse.class);
    }
}
