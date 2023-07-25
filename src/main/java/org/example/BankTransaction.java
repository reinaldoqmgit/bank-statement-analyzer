package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    final private LocalDate date;
    final private double amount;
    final private String description;
    BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public double getAmount() {
        return this.amount;
    }
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return this.date.equals(that.date)
                && Double.compare(this.amount, that.amount) == 0
                && this.description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
