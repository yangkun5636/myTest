package com.ben.boot.controller;

import com.github.wxpay.sdk.WXPayUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.*;

public class UserControllerTest {

    @Test
    public void demo() throws Exception {
        Map<String,String> map = new HashMap<>();
        String s = WXPayUtil.generateNonceStr().toUpperCase(Locale.CHINA);
        System.out.println(s);
        String s1 = WXPayUtil.generateSignature(map, s);
        System.out.println(s1);
    }
}