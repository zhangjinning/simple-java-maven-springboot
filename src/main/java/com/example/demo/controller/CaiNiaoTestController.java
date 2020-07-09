package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.enums.CaiNiaoTestEnum;
import com.example.demo.util.MD5Utils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        JSONObject caiNiaoCallbackReturnMsg = new JSONObject();
        caiNiaoCallbackReturnMsg.put("accessCode", accessCode);
        caiNiaoCallbackReturnMsg.put("appkey", appkey);

        JSONObject json = new JSONObject();
        json.put("errCode", 200);
        json.put("errMsg", caiNiaoCallbackReturnMsg);
        json.put("ext", "test1");

        String tokenUrl = "http://lcp.cloud.cainiao.com/api/permission/exchangeToken.do";
        tokenUrl += "?accessCode=" + accessCode;
        tokenUrl += "&isvAppkey=" + appkey;
        // TODO md5(accessCode + "," + appKey + "," + appSecret);
        tokenUrl += "&sign=" + MD5Utils.md5(accessCode +
                "," +
                appkey +
                "," +
                CaiNiaoTestEnum.CAI_NIAO_TEST_ENUM.getAppSecret());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(tokenUrl);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (200 == response.getStatusLine().getStatusCode()) {
                String r = EntityUtils.toString(response.getEntity(), "UTF-8");
                log.info("res: \n" + r);
            }
            httpClient.close();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        
        return json;
    }
}
