package com.zen.pattern.services.component;

import com.zen.pattern.dto.Report;
import com.zen.pattern.services.ReportGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExcelReportGenerator implements ReportGenerator {
    @Override
    public String generateReport(Report report) {
        log.info("start generate report Excel");
        return String.format("Excel report generated : %s", report.getReportType());
    }
}
