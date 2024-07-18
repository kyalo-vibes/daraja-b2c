package com.kyalo.daraja_b2c.services;

import com.google.gson.Gson;
import com.kyalo.daraja_b2c.models.B2CRequest;
import com.kyalo.daraja_b2c.models.Transaction;
import com.kyalo.daraja_b2c.models.TransactionStatusResponse;
import com.kyalo.daraja_b2c.models.UpdateRequest;
import com.kyalo.daraja_b2c.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class B2CService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MpesaService mpesaService;

    public void processB2CRequest(B2CRequest b2cRequest) {
        // Validate and process B2C request
        Transaction transaction = new Transaction();
        transaction.setOrderId(b2cRequest.getOrderId());
        transaction.setReceiverIdentityId(b2cRequest.getReceiverIdentityId());
        transaction.setTransactionAmount(b2cRequest.getTransactionAmount());
        transaction.setTransactionCost(b2cRequest.getTransactionCost());
        transaction.setTransStatus("Pending");
        transactionRepository.save(transaction);

        kafkaTemplate.send("b2c-requests", serializeRequest(b2cRequest));
    }

    public TransactionStatusResponse getPaymentStatus(String transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return new TransactionStatusResponse(transaction.getTransStatus());
    }

    public void updatePaymentStatus(UpdateRequest updateRequest) {
        Transaction transaction = transactionRepository.findById(updateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setTransStatus(updateRequest.getStatus());
        transactionRepository.save(transaction);

        kafkaTemplate.send("b2c-status-updates", serializeUpdate(updateRequest));
    }

    private String serializeRequest(B2CRequest b2cRequest) {
        // Serialize B2C request to JSON string
        return new Gson().toJson(b2cRequest);
    }

    private String serializeUpdate(UpdateRequest updateRequest) {
        // Serialize update request to JSON string
        return new Gson().toJson(updateRequest);
    }
}
