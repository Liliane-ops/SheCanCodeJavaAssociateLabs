package com.banking.transactions;

public class FraudDetectedException extends TransactionException {

    public FraudDetectedException(String errorCode, String message) {
        super(errorCode, message);
    }
}