package cn.ben;

import com.alibaba.dubbo.container.Main;

public class Application {
    public static void main(String[] args) {
        // 在 pom 中配置打包信息
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        Main.main(args);
    }
}
