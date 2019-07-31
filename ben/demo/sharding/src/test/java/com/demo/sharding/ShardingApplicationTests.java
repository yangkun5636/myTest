package com.demo.sharding;

import com.demo.sharding.domain.UserAccount;
import com.demo.sharding.service.UserAccountService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.demo.sharding.mapper")
public class ShardingApplicationTests {

    @Autowired
    private UserAccountService userAccountService;

    @Test
    public void contextLoads() {
        List<UserAccount> userAccounts = userAccountService.selectAll();
        System.out.println(userAccounts.size());
    }

}
