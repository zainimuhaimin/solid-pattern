package com.zen.pattern.services;

import com.zen.pattern.dto.Report;

public interface EmailService {
    void sendReportByEmail(Long reportId, String to, String subject);
}
