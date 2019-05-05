package com.ben.boot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangkun
 */
@Controller
@RequestMapping("/http")
public class HttpController {

    @ResponseBody
    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> param = new HashMap<>();
        param.put("method", request.getMethod());
        param.put("requestURL", request.getRequestURL());
        param.put("requestURI", request.getRequestURI());
        param.put("remoteUser", request.getRemoteUser());
        param.put("parameterMap", request.getParameterMap());
        param.put("remoteAddr",request.getRemoteAddr());
        param.put("localAddr",request.getLocalAddr());
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(param);
        return jsonObject.toJSONString();
    }
}
