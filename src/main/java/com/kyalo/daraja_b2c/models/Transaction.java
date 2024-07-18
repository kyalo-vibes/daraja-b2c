package com.kyalo.daraja_b2c.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String orderId;
    private String externalOrderId;
    private String transStatus;
    private LocalDateTime accountingDate;
    private LocalDateTime transInitTime;
    private LocalDateTime transEndTime;
    private String identityId;
    private double transactionAmount;
    private double transactionCost;
    private double beforeTransactionBalance;
    private double afterTransactionBalance;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private String receiverIdentityId;
    private String errorCode;
    private String errorDesc;
    private String sign;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public LocalDateTime getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(LocalDateTime accountingDate) {
        this.accountingDate = accountingDate;
    }

    public LocalDateTime getTransInitTime() {
        return transInitTime;
    }

    public void setTransInitTime(LocalDateTime transInitTime) {
        this.transInitTime = transInitTime;
    }

    public LocalDateTime getTransEndTime() {
        return transEndTime;
    }

    public void setTransEndTime(LocalDateTime transEndTime) {
        this.transEndTime = transEndTime;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(double transactionCost) {
        this.transactionCost = transactionCost;
    }

    public double getBeforeTransactionBalance() {
        return beforeTransactionBalance;
    }

    public void setBeforeTransactionBalance(double beforeTransactionBalance) {
        this.beforeTransactionBalance = beforeTransactionBalance;
    }

    public double getAfterTransactionBalance() {
        return afterTransactionBalance;
    }

    public void setAfterTransactionBalance(double afterTransactionBalance) {
        this.afterTransactionBalance = afterTransactionBalance;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getReceiverIdentityId() {
        return receiverIdentityId;
    }

    public void setReceiverIdentityId(String receiverIdentityId) {
        this.receiverIdentityId = receiverIdentityId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


}
