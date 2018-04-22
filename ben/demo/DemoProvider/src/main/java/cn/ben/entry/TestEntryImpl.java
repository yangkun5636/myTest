package cn.ben.entry;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class TestEntryImpl implements TestEntry {
    public String test() {
        return "test";
    }

    public String name() {
        return "name";
    }
}
