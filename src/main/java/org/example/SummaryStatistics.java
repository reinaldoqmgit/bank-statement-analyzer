package org.example;

public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;
    public SummaryStatistics(double sum, double max, double min, double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }
    public double getSum() {
        return this.sum;
    }
    public double getMax() {
        return this.max;
    }
    public double getMin() {
        return this.min;
    }
    public double getAverage() {
        return this.average;
    }
}

