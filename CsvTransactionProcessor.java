package com.banking.transactions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvTransactionProcessor {

    public void processFile(String filePath) {

        List<ParseError> errors = new ArrayList<>();

        int processed = 0;
        int failed = 0;
        int lineNumber = 0;

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                lineNumber++;

                try {

                    String[] data = line.split(",");

                    if (data.length != 3) {
                        throw new IllegalArgumentException(
                                "Invalid CSV format"
                        );
                    }

                    processed++;

                } catch (Exception e) {

                    failed++;

                    errors.add(
                            new ParseError(
                                    lineNumber,
                                    line,
                                    e.getMessage()
                            )
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "File Error: " + e.getMessage()
            );
        }

        System.out.println(
                "Processed: " + processed +
                        ", Failed: " + failed
        );

        writeErrors(errors);
    }

    private void writeErrors(List<ParseError> errors) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     "failed_records.txt"
                             ))) {

            for (ParseError error : errors) {

                writer.write(error.toString());
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error writing failures file."
            );
        }
    }
}