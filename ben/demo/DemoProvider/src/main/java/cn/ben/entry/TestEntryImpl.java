package cn.ben.entry;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestEntryImpl implements TestEntry {
    public String test() {
        System.out.println("provider test : test");
        return "test";
    }


    @Transactional
    public String name() {
        System.out.println("provider name : name");
        return "name";
    }
}
