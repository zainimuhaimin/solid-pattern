package com.zen.pattern.services.impl;

import com.zen.pattern.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendReportByEmail(Long reportId, String to, String subject) {
        log.info("start send report by email report Id : {}, to : {}, subject : {}", reportId, to, subject);
        if (ObjectUtils.isEmpty(reportId)){
            throw new RuntimeException("report id has null value");
        }
    }
}
