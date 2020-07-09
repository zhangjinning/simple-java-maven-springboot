package com.example.demo.domain.enums;

public enum CaiNiaoTestEnum {
    CAI_NIAO_TEST_ENUM("120509",
            "j6M202904cT8YA8KCd08bkj33Ij29z95");

    private String appKey;

    private String appSecret;

    CaiNiaoTestEnum(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }
}
