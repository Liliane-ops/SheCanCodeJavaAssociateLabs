package com.banking.transactions;

import java.sql.SQLException;

public class DatabaseService {

    public double getAccountBalance(String accountId)
            throws DataAccessException {

        try {

            // Simulated database error
            throw new SQLException(
                    "Database connection failed."
            );

        } catch (SQLException e) {

            throw new DataAccessException(
                    "Unable to retrieve account balance.",
                    e
            );
        }
    }
}
