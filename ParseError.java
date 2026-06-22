package com.banking.transactions;

public class ParseError {

    private int lineNumber;
    private String lineContent;
    private String errorMessage;

    public ParseError(int lineNumber, String lineContent, String errorMessage) {
        this.lineNumber = lineNumber;
        this.lineContent = lineContent;
        this.errorMessage = errorMessage;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLineContent() {
        return lineContent;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "Line " + lineNumber +
                " | Error: " + errorMessage +
                " | Data: " + lineContent;
    }
}