package org.example;

public class HtmlExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!DOCTYPE html>";
        result += "<html>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li>The sum is: " + summaryStatistics.getSum() +"</li>";
        result += "<li>The maximum is: " + summaryStatistics.getMax() +"</li>";
        result += "<li>The minimum is: " + summaryStatistics.getMin() +"</li>";
        result += "<li>The average is: " + summaryStatistics.getAverage() +"</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
