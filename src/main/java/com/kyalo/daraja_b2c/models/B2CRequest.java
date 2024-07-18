package com.kyalo.daraja_b2c.models;

import lombok.Data;

@Data
public class B2CRequest     {

    private String orderId;
    private String receiverIdentityId;
    private double transactionAmount;
    private double transactionCost;
//    private String Amount;
//    private String MpesaReceiptNumber;
//    private String PhoneNumber;
//    private String TransactionType;
//    private String PartyA;
//    private String PartyB;
//    private String PassKey;
}
