package com.banking.transactions;

public class InsufficientFundsException extends TransactionException {

    public InsufficientFundsException(String errorCode, String message) {
        super(errorCode, message);
    }
}