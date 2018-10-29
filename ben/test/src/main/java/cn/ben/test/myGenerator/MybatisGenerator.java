package cn.ben.test.myGenerator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MybatisGenerator implements CommentGenerator {
    private Properties properties;
    private Properties systemPro;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;

    public MybatisGenerator() {
        super();
        properties = new Properties();
        systemPro = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        MybatisGenerator generator = new MybatisGenerator();
        File configFile = new File(generator.getClass().getResource("/").getPath() + "/myGenerator/config2.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(configFile);
        DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
        myBatisGenerator.generate(null);
    }

    private String getDir() {
        URL resource = this.getClass().getResource("");
        return resource.getPath();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        System.out.println("addConfigurationProperties");
        this.properties.putAll(properties);
        suppressDate = (boolean) properties.get(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE);
        suppressAllComments = (boolean) properties.get(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS);

    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        System.out.println("addFieldComment1");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        System.out.println("addFieldComment2");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        System.out.println("addClassComment1");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
        System.out.println("addClassComment2");
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        System.out.println("addEnumComment");
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        System.out.println("addGetterComment");
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        System.out.println("addSetterComment");
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        System.out.println("addGeneralMethodComment");
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        System.out.println("addJavaFileComment");
    }

    @Override
    public void addComment(XmlElement xmlElement) {
        System.out.println("addComment");
    }

    @Override
    public void addRootComment(XmlElement xmlElement) {
        System.out.println("addRootComment");
    }
}
