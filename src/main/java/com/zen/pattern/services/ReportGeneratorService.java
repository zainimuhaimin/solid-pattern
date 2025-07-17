package com.zen.pattern.services;

import com.zen.pattern.dto.Report;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReportGeneratorService {

    private final Map<String, ReportGenerator> reportGenerators;

    @Autowired
    public ReportGeneratorService(List<ReportGenerator> generators) {
        // assign value untuk reportGenerators dari List<ReportGenerator> lalu stream List<ReportGenerator>
//        dan mapping value ke dalam reportGenerators
        this.reportGenerators = generators.stream()
                .collect(Collectors.toMap(generator -> generator.getClass().getSimpleName(), Function.identity()));
    }


    public String generateReport(Report report) {
        log.info("start generate report : {}", report.getReportType());
        // get generator by report type
        return reportGenerators.getOrDefault(report.getReportType(), unsupportReportGenerator()).generateReport(report);
    }

    private ReportGenerator unsupportReportGenerator() {
        // return string in interface
        return report -> "unsupport Report Generator";
    }
}
