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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

public class MyGenerator implements CommentGenerator {
    private Properties properties;
    private Properties systemPro;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;

    public MyGenerator() {
        super();
        properties = new Properties();
        systemPro = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static void main(String[] args) throws Exception {
//        List<String> warnings = new ArrayList<>();
//        boolean overwrite = true;
//        MyGenerator generator = new MyGenerator();
//        File configFile = new File(generator.getClass().getResource("/").getPath() + "/myGenerator/generatorConfig.xml");
//        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
//        Configuration configuration = configurationParser.parseConfiguration(configFile);
//        DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
//        myBatisGenerator.generate(null);
        MyGenerator myGenerator = new MyGenerator();
        myGenerator.generatorMysql22("myConfig.xml");
    }

    public void generatorMysql22(String fileName) throws Exception {
        File file = new File(this.getClass().getResource("/").getPath() + "/myGenerator/" + fileName);
        ConfigurationParser parser = new ConfigurationParser(null);
        Configuration configuration = parser.parseConfiguration(file);

        DefaultShellCallback callback = new DefaultShellCallback(true);

        MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, null);
        generator.generate(null);
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        System.out.println("addConfigurationProperties");
        this.properties.putAll(properties);
        suppressDate = Boolean.getBoolean((String) properties.get(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        suppressAllComments = Boolean.valueOf((String) properties.get(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
        System.out.println("addFieldComment1");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        System.out.println("addFieldComment2");
    }

    /**
     *
     * @param topLevelClass
     *            the top level class
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addAnnotation("/**");
        topLevelClass.addAnnotation(" * "+introspectedTable.getRemarks());
        topLevelClass.addAnnotation(" */");
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addImportedType("lombok.Data");
        System.out.println("addModelClassComment");
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

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        System.out.println("addGeneralMethodAnnotation");
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        System.out.println("addGeneralMethodAnnotation345");
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        System.out.println("addFieldAnnotation34");
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        System.out.println("addFieldAnnotation32");
    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        System.out.println("addClassAnnotation12312");
    }
}
