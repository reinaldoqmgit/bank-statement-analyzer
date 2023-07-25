package org.example;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzer {
    final private String RESOURCES = "src/main/resources/";
    public void analyze(String fileName, BankStatementParser bankStatementParser, Exporter exporter)
            throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();

        System.out.println(exporter.export(summaryStatistics));
    }
}


