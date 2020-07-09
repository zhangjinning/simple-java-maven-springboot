package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/cainiaoTest")
public class CaiNiaoTestController {

    private static final Logger log = LoggerFactory.getLogger(CaiNiaoTestController.class);

    @GetMapping("/callback1")
    public JSONObject caiNiaoCallback(HttpServletRequest req,
                                HttpServletResponse res) {
        String accessCode = req.getParameter("accessCode");
        String appkey = req.getParameter("appkey");
        log.info("accessCode: " + accessCode);
        log.info("appkey: " + appkey);
        JSONObject json = new JSONObject();
        json.put("errCode", 200);
        json.put("errMsg", "success");
        json.put("ext", "test1");
        return json;
    }
}
