package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    private static final Logger log = LoggerFactory.getLogger(MD5Utils.class);

    private MD5Utils() {}

    public static byte[] md5Bytes(String text) {
        if (StringUtils.isEmpty(text)) {
            return new byte[0];
        }
        return md5Bytes(text.getBytes());
    }

    public static byte[] md5Bytes(byte[] bytes) {
        MessageDigest msd = null;
        try {
            msd = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.info(e.getMessage());
        }
        msd.update(bytes);
        byte[] digest = msd.digest();
        return digest;
    }

    public static String md5(String text,
                             boolean ifReturnRaw) {
        if (StringUtils.isEmpty(text)) {
            return text;
        }
        byte[] bytes = md5Bytes(text);
        return md5Hex(bytes, false);
    }

    public static String md5(byte[] bytes,
                             boolean ifReturnRaw) {
        byte[] bytes1 = md5Bytes(bytes);
        return md5Hex(bytes1, ifReturnRaw);
    }

    public static String md5Hex(byte[] bytes,
                                 boolean ifReturnRaw) {
        if (ifReturnRaw) {
            return new String(bytes);
        }

        String md5Str = new String();
        byte bt;
        char low, high, tmpChar;
        for (int i = 0; i < bytes.length; i++) {
            bt = bytes[i];
            tmpChar = (char) ((bt >>> 4) & 0x000f);
            if (tmpChar >= 10) {
                high = (char) (('a' + tmpChar) - 10);
            } else {
                high = (char) ('0' + tmpChar);
            }
            md5Str += high;

            tmpChar = (char) (bt & 0x000f);
            if (tmpChar >= 10) {
                low = (char) (('a' + tmpChar) - 10);
            } else {
                low = (char) ('0' + tmpChar);
            }
            md5Str += low;
        }
        return md5Str;
    }

    public static String md5(String text) {
        return md5(text, false);
    }

    public static String md5(byte[] bytes) {
        return md5(bytes, false);
    }
}
