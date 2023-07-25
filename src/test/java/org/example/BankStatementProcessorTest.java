package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankStatementProcessorTest {
    @Test
    public void shouldFilterInAugust() {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        BankTransaction bankTransactionInFebruary =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10), 100, "Monitor");
        BankTransaction bankTransactionInAugust =
                new BankTransaction(LocalDate.of(2023, Month.AUGUST, 23), 50, "Mouse");
        bankTransactions.add(bankTransactionInAugust);
        bankTransactions.add(bankTransactionInFebruary);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        List<BankTransaction> result = bankStatementProcessor.findTransactions((bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.AUGUST));

        assertTrue(result.contains(bankTransactionInAugust));
        assertFalse(result.contains(bankTransactionInFebruary));
        assertEquals(1, result.size());
    }
    @Test
    public void shouldFilterTransactionsGreaterEqualThan1000() {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        BankTransaction bankTransactionForAmount1000 =
                new BankTransaction(LocalDate.of(2023, Month.AUGUST, 23), 1000, "Product");
        BankTransaction bankTransactionForAmount2500 =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10), 2500, "Product");
        BankTransaction bankTransactionForAmount999 =
                new BankTransaction(LocalDate.of(2023, Month.AUGUST, 23), 999, "Product");
        BankTransaction bankTransactionForAmount100 =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10), 100, "Product");
        bankTransactions.add(bankTransactionForAmount100);
        bankTransactions.add(bankTransactionForAmount999);
        bankTransactions.add(bankTransactionForAmount1000);
        bankTransactions.add(bankTransactionForAmount2500);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        List<BankTransaction> result = bankStatementProcessor.findTransactionsGreaterThanEqual(1000);

        assertTrue(result.contains(bankTransactionForAmount1000));
        assertTrue(result.contains(bankTransactionForAmount2500));
        assertFalse(result.contains(bankTransactionForAmount100));
        assertFalse(result.contains(bankTransactionForAmount999));
        assertEquals(2, result.size());
    }
    @Test
    public void shouldCalculateTotalInFebruary () {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        BankTransaction bankTransactionInAugust1 =
                new BankTransaction(LocalDate.of(2023, Month.AUGUST, 23), 1000, "Product");
        BankTransaction bankTransactionInFebruary1 =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10), 2500, "Product");
        BankTransaction bankTransactionInAugust2 =
                new BankTransaction(LocalDate.of(2023, Month.AUGUST, 23), 999, "Product");
        BankTransaction bankTransactionInFebruary2 =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10), 100, "Product");
        bankTransactions.add(bankTransactionInAugust1);
        bankTransactions.add(bankTransactionInAugust2);
        bankTransactions.add(bankTransactionInFebruary1);
        bankTransactions.add(bankTransactionInFebruary2);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        double result = bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY);

        assertEquals(2600, result);
    }
    @Test
    public void shouldSummarizeAmountsOfTwoTransactions() {
        BankTransaction bankTransaction1 =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10), 10, "Item");
        BankTransaction bankTransaction2 =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 11), 40, "Item");
        List<BankTransaction> bankTransactions = new ArrayList<>();
        bankTransactions.add(bankTransaction1);
        bankTransactions.add(bankTransaction2);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        SummaryStatistics result = bankStatementProcessor.summarizeTransactions();

        SummaryStatistics expected = new SummaryStatistics(50, 40, 10, 25);

        assertEquals(expected.getSum(), result.getSum());
        assertEquals(expected.getMax(), result.getMax());
        assertEquals(expected.getMin(), result.getMin());
        assertEquals(expected.getAverage(), result.getAverage());
    }
}