package com.demo.sharding.controller;

import com.demo.sharding.domain.UserAccount;
import com.demo.sharding.service.UserAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangkun
 * @see
 * @since
 */
@Controller
public class UserAccountController {

    @Autowired
    private UserAccountService service;

    @ResponseBody
    @RequestMapping("/all")
    public List<UserAccount> selectAll() {
        List<UserAccount> userAccounts = service.selectAll();
        return userAccounts;
    }
}
