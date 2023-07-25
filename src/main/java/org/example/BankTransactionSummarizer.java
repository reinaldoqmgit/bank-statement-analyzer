package org.example;

public interface BankTransactionSummarizer {
    public double summarize(double accumulator, BankTransaction bankTransaction);
}
