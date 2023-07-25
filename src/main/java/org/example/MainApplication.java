package org.example;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        final String fileName = "transactions.txt";

        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        Exporter exporter = new HtmlExporter();

        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze(fileName, bankStatementParser, exporter);
    }
}
