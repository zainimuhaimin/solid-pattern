package com.zen.pattern.services.impl;

import com.zen.pattern.dto.Report;
import com.zen.pattern.services.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    // in SRC, services only has own responsibility
    @Override
    public Long generateReport(String reportContent) {
        log.info("start generate report : {}", reportContent);
        // let say this function for generate report
        Report report =  Report.builder()
                .reportContent("report-content")
                .build();

        Long reportId = 1L;
        if (StringUtils.isEmpty(reportContent)) reportId = null;
        return reportId;
    }
}
