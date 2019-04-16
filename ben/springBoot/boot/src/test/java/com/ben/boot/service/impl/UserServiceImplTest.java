package com.ben.boot.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class UserServiceImplTest {

    private static final String key = "192006250b4c09247ec02edce69f6a2d";

    @Test
    public void WXUrlEncode() throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("user", "陈志涛");
        param.put("age", "24");
        param.put("address", "上海市");
        param.put("company", "金仕达卫宁");
        log.info("参数:{}", param);
        String sign = WXPayUtil.generateSignature(param, key);
        log.info("sign:{}", sign);
    }

}