package com.kyalo.daraja_b2c.repositories;

import com.kyalo.daraja_b2c.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
