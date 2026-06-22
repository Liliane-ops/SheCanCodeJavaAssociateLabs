package com.banking.transactions;

public class TransactionException extends Exception {

    private String errorCode;

    public TransactionException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return "[" + errorCode + "] " + super.getMessage();
    }
}