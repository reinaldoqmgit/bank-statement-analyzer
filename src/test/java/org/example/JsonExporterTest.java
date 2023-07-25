package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonExporterTest {
    @Test
    public void shouldExportSummaryStatisticsInJson() {
        final SummaryStatistics summaryStatistics = new SummaryStatistics(1, 1, 1, 1);
        final JsonExporter jsonExporter = new JsonExporter();
        String result = jsonExporter.export(summaryStatistics);
        String expected = "{" +
            "\"sum\": 1.0, " +
            "\"max\": 1.0, " +
            "\"min\": 1.0, " +
            "\"average\": 1.0" +
            "}";
        assertEquals(expected, result);
    }
}