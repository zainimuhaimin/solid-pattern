package com.zen.pattern.controller;

import com.zen.pattern.dto.Report;
import com.zen.pattern.services.EmailService;
import com.zen.pattern.services.ReportGeneratorService;
import com.zen.pattern.services.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {
    /***
     * implementasi dari SOLID Patter
     *
     *
     * 1. Single Responsibility Principal (SRC)
     * di SRC ini tiap2 service harus menjalankan tanggung jawabnya masing masing jadi tidak boleh
     * ada service yang mengerjakan tugas service lain
     *
     * 2. Open Closed Principle (OCP)
     * apabila ada if yang bertumpuk atau misalnya ingin membuat report generator yang ekstensi nya itu bisa pdf,excel,
     * word, dll. maka OCP ini adalah solusi terbaik untuk di implementasi karena untuk memaintain jadi lebih mudah
     * dan tidak merubah logic if yang banyak
     * steps
     * buatlah interface exmp ReportGenerator dengan method generateReport.
     * setelah itu buat implementasinya untuk interface ReportGenerator dan tentukan logic yang ingin di buat.
     * buat base service dengan nama ReportGeneratorServices lalu inisiasi varialbel dengan type Map<String, Interfaces>
     *     disini gua pake Map<String, ReportGenerator>, lalu buat constructor untuk assign valuenya ke variable yang
     *     sudah di inisiai nah gua taroin di parameternya dengan List<ReportGenerator> karna gua mau ambil class namenya
     *     sebagai keynya, dan function Identity itu sendiri.
     *     sisanya tinggal bikin generate report function dan tinggal lu panggil deh variable yang lu inisiasi tadi
     *     lalu getOrDefault(ambil dari request, default function yang mau lo lembar).
     *
     * 3. Liskov's Subtitution Principle (LSP) itu ada di Bird Controller
     */

    @Autowired
    private ReportService reportService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ReportGeneratorService reportGeneratorService;

    // implement Single Responsibility Principal (SRP)
    @GetMapping("/send")
    public ResponseEntity<String> sendReportByEmail(@RequestParam String content,
                                                    @RequestParam String to,
                                                    @RequestParam String subject) {
        log.info("implement single responsibility principle");
        Long reportId = reportService.generateReport(content);
        emailService.sendReportByEmail(reportId, to, subject);
        return ResponseEntity.ok().body("success send report");
    }


    // implement Open Closed Principle
    @GetMapping("/generate")
    public ResponseEntity<String> reportGenerator(@RequestParam String reportType) {
        Report report = Report.builder().reportType(reportType).build();
        String result = reportGeneratorService.generateReport(report);
        return ResponseEntity.ok().body(result);
    }
}
