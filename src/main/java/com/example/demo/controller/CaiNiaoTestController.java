package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/cainiaoTest")
public class CaiNiaoTestController {

    @GetMapping("/callback1")
    public void caiNiaoCallback(HttpServletRequest req,
                                HttpServletResponse res) {
        String accessCode = req.getParameter("accessCode");
        String appkey = req.getParameter("appkey");
        log.info("accessCode: " + accessCode);
        log.info("appkey: " + appkey);
    }
}
