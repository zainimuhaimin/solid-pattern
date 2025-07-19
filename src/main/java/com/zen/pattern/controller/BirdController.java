package com.zen.pattern.controller;

import com.zen.pattern.services.CrowService;
import com.zen.pattern.services.EagleService;
import com.zen.pattern.services.PenguinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BirdController {

    /**
     * 3. Liskov's Subtitution Principle (LSP)
     * <p>
     * controller ini akan mengimplementasikan untuk Liskov's Subtitution Principle
     * nah menurut gua untuk LSP ini adalah
     * Superclass itu harus bersifat general.
     * Kalau mau kasih perilaku yang lebih spesifik, harusnya subclass yang menanganinya,
     * dan subclass itu harus tetap bisa digunakan sebagai superclass tanpa bikin kode error atau berubah perilakunya.
     * <p>
     * 4. Interface Segregation Principle (ISP)
     * basicly ISP ini mirip kayak LSP karna ISP ini membuat interfaces class secara spesifik dan tinggal implements
     * class interface yang spesifik tsb
     * jadi ISP adalah Clients should not be forced to depend on interfaces they do not use.
     * sederhananya Jangan bikin interface yang terlalu gemuk atau serba bisa.
     * Class sebaiknya hanya implement method-method yang memang dia butuhkan saja. Kalau nggak,
     * dia bakal "dipaksa tahu hal yang nggak penting buat dia."
     */

    private static final String PENGUIN = "penguin";
    private static final String EAGLE = "eagle";


    @Autowired
    private EagleService eagleService;

    @Autowired
    private PenguinService penguinService;

    @Autowired
    private CrowService crowService;

    @GetMapping("/bird")
    public ResponseEntity<String> getBirdCharacteristicLSP(@RequestParam String bird) {
        log.info("bird request : {}", bird);
        // disini bisa lu combine pake OCP (open close principle)
        String result = null;
        if (PENGUIN.equalsIgnoreCase(bird)) {
            result = penguinService.swim(bird);
        } else if (EAGLE.equalsIgnoreCase(bird)) {
            result = eagleService.fly(bird);
        } else {
            throw new RuntimeException("error no parameter or bird not found");
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/bird/crown")
    public ResponseEntity<String> getBirdCharISP() {
        String walk = crowService.walk("crown");
        String fly = crowService.fly("crown");

        String result = String.format(walk.concat(" and ").concat(fly));

        return ResponseEntity.ok().body(result);
    }


}
