package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/tm")
public class TimeTransController {

    private static final Logger log = LoggerFactory.getLogger(TimeTransController.class);

    @GetMapping("/{timestamp}")
    public String transTimestamp(@PathVariable String timestamp) {
        String result = "null";
        // TODO 时间戳处理
        if (timestamp.length() > 10) {
            timestamp = timestamp.substring(0, 10);
        }
        Long sl = Long.valueOf(timestamp);
        LocalDateTime ldt = null;
        try {
            ldt = LocalDateTime.ofEpochSecond(sl, 0, ZoneOffset.ofHours(8));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            result = dtf.format(ldt);
        } catch (Exception e) {
            log.info(e.getMessage());
            result = "您输入的不是时间戳(`皿´)";
        }

        return result;
    }
}
