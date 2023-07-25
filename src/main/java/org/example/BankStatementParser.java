package org.example;

import java.util.List;

public interface BankStatementParser {
    public BankTransaction parseFrom(String line);
    public List<BankTransaction> parseLinesFrom(List<String> lines);
}

