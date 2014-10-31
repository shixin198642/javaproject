package com.shixin.crypto;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by shixin on 10/31/14.
 */
public class TestDigest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = RandomStringUtils.random(64);
        System.out.println("name: " + name);
        System.out.println("name length: " + name.length());

        byte[] md5 = DigestUtils.md5(name);
        System.out.println("md5 length: " + md5.length);

        // 观察不同encode方法
        String base64 = Base64.encodeBase64String(md5); // 会包含\n\r
        System.out.println("base64: " + base64);
        System.out.println("base64 length: " + base64.length());

        base64 = Base64.encodeBase64URLSafeString(md5); // 适用于URL
        System.out.println("base64: " + base64);
        System.out.println("base64 length: " + base64.length());

        base64 = new String(Base64.encodeBase64(md5), "UTF-8");
        System.out.println("base64: " + base64);
        System.out.println("base64 length: " + base64.length());
    }
}
