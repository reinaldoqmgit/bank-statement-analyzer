package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankStatementCSVParserTest {
    private final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "10-02-2023,100,Headphones";
        final BankTransaction result = bankStatementCSVParser.parseFrom(line);
        final BankTransaction expected =
                new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10),
                        100, "Headphones");
        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount());
        assertEquals(expected.getDescription(), result.getDescription());
    }
    @Test
    public void shouldParseTwoCorrectLines() throws Exception {
        final List<String> lines = new ArrayList<>();
        lines.add("10-02-2023,100,Headphones");
        lines.add("23-08-2023,750,Smartphone");
        final List<BankTransaction> result = bankStatementCSVParser.parseLinesFrom(lines);
        final List<BankTransaction> expected = new ArrayList<>();
        expected.add(new BankTransaction(LocalDate.of(2023, Month.FEBRUARY, 10),
                100, "Headphones"));
        expected.add(new BankTransaction(LocalDate.of(2023, Month.AUGUST, 23),
                750, "Smartphone"));
        assertEquals(expected.get(0), result.get(0));
        assertEquals(expected.get(1), result.get(1));
    }
}