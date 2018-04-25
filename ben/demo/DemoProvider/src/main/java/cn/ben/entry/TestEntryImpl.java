package cn.ben.entry;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestEntryImpl implements TestEntry {
    public String test() {
        return "test";
    }


    @Transactional
    public String name() {
        return "name";
    }
}
