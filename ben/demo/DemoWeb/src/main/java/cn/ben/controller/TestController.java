package cn.ben.controller;

import cn.ben.entry.TestEntry;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @TIME 2018/4/24 16:52
 * @User yangkun
 * @DESCRIPTION
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Reference
    private TestEntry entry;

    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String test = entry.test();
        modelMap.put("test", test + "1123123");
        ModelAndView modelAndView = new ModelAndView("test", modelMap);
        return modelAndView;
    }

}
