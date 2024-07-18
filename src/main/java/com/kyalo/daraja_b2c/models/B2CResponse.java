package com.kyalo.daraja_b2c.models;

import lombok.Data;

@Data
public class B2CResponse {
    private String id;  // Transaction ID
    private String status;  // Status of the transaction
    private String externalOrderId;  // Identifier from Daraja
    private String errorCode;  // Error code if any error occurred
    private String errorDesc;  // Error description if any error occurred

}