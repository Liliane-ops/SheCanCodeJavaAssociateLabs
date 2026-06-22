package com.banking.transactions;

public class Lab12Main {

    public static void main(String[] args) {

        Account account1 =
                new Account(
                        "ACC001",
                        "Celine",
                        5000
                );

        Account account2 =
                new Account(
                        "ACC002",
                        "Eunice",
                        1000
                );

        TransactionService service =
                new TransactionService();

        try {

            service.transfer(
                    account1,
                    account2,
                    2000
            );

            System.out.println(account1);
            System.out.println(account2);

        } catch (TransactionException e) {

            System.out.println(
                    "Transfer Failed: "
                            + e.getMessage()
            );
        }

        DatabaseService db =
                new DatabaseService();

        try {

            db.getAccountBalance("ACC001");

        } catch (DataAccessException e) {

            System.out.println(
                    "Database Error: "
                            + e.getMessage()
            );

            System.out.println(
                    "Original Cause: "
                            + e.getCause()
            );
        }

        CsvTransactionProcessor processor =
                new CsvTransactionProcessor();

        processor.processFile(
                "transactions.csv"
        );
    }
}