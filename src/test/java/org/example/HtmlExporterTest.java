package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlExporterTest {
    @Test
    public void shouldExportSummaryStatisticsInHtml() {
        final SummaryStatistics summaryStatistics = new SummaryStatistics(1, 1, 1, 1);
        final HtmlExporter htmlExporter = new HtmlExporter();
        final String result = htmlExporter.export(summaryStatistics);
        final String expected = "<!DOCTYPE html>" +
                "<html>" +
                "<head><title>Bank Transaction Report</title></head>" +
                "<body>" +
                "<ul>" +
                "<li>The sum is: 1.0</li>" +
                "<li>The maximum is: 1.0</li>" +
                "<li>The minimum is: 1.0</li>" +
                "<li>The average is: 1.0</li>" +
                "</ul>" +
                "</body>" +
                "</html>";
        assertEquals(expected, result);
    }
}