package com.banking.transactions;

public class TransactionService {

    public void transfer(Account from,
                         Account to,
                         double amount)
            throws TransactionException {

        if (amount > 10000) {
            throw new FraudDetectedException(
                    "FRAUD-001",
                    "Suspicious transaction detected."
            );
        }

        if (from.getBalance() < amount) {
            throw new InsufficientFundsException(
                    "BAL-001",
                    "Insufficient funds."
            );
        }

        from.withdraw(amount);
        to.deposit(amount);

        System.out.println("Transfer successful!");
    }
}