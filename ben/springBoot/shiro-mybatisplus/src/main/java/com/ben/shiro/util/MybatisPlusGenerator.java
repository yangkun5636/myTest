//package com.ben.shiro.util;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author yangkun
// */
//public class MybatisPlusGenerator {
//
//    public static void main(String[] args) {
//        AutoGenerator generator = new AutoGenerator();
//        //设置全局配置
//        generator.setGlobalConfig(globalConfig());
//        //设置数据源
//        generator.setDataSource(dataSource());
//        //设置包路径
//        generator.setPackageInfo(packageConfig());
//        //自定义配置
//        //generator.setCfg(new MyConfig());
//        //策略配置
//        generator.setStrategy(strategyConfig());
//
//        //模板
//        //generator.setTemplate()
//        //模板引擎
//        //generator.setTemplateEngine()
//        generator.execute();
//    }
//
//    private static GlobalConfig globalConfig() {
//        GlobalConfig config = new GlobalConfig();
//        String userDir = System.getProperty("user.dir");
//        config.setOutputDir("d:/src/main/java");
//        config.setAuthor("yangkun");
//        config.setOpen(false);
//        config.setSwagger2(true);
//        //活动记录（一个实体类继承Model类，并通过注解与数据库的表名进行关联，这样就可以通过实体类直接进行表的简单增删改查操作）
//        config.setActiveRecord(true);
//        //二级缓存
//        config.setEnableCache(true);
//        config.setBaseResultMap(true);
//        config.setBaseColumnList(true);
//        config.setServiceName("%sService");
//        config.setDateType(DateType.valueOf(Date.class.getName()));
////        config.setKotlin(true);
//        config.setIdType(IdType.AUTO);
//        config.setFileOverride(true);
//        return config;
//    }
//
//    private static DataSourceConfig dataSource() {
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://127.0.0.1:3307/ben?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        return dsc;
//    }
//
//    private static PackageConfig packageConfig() {
//        PackageConfig packageConfig = new PackageConfig();
//        packageConfig.setParent("");
//        packageConfig.setController("com.ben.shiro.controller");
//        packageConfig.setEntity("com.ben.shiro.pojo.bo");
//        packageConfig.setMapper("com.ben.shiro.mapper");
//        packageConfig.setService("com.ben.shiro.service");
//        packageConfig.setServiceImpl("com.ben.shiro.service.impl");
//        return packageConfig;
//    }
//
//    private static StrategyConfig strategyConfig() {
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
//        // entity 采用lombok注解
//        strategyConfig.setEntityLombokModel(true);
//        // rest Controller
//        strategyConfig.setRestControllerStyle(true);
////        strategyConfig.setSuperControllerClass("com.baomidou.ant.common.BaseController");
////        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategyConfig.setSuperEntityColumns("id");
//        strategyConfig.setControllerMappingHyphenStyle(true);
////        strategyConfig.setTablePrefix(pc.getModuleName() + "_");
////        strategyConfig.setEntityTableFieldAnnotationEnable(false);
//        //去掉表明前缀，S_SYS -> SYS
//        strategyConfig.setTablePrefix("B", "S");
//        return strategyConfig;
//    }
//
//}
//
//class MyConfig extends InjectionConfig {
//
//    @Override
//    public void initMap() {
//        ConfigBuilder config = this.getConfig();
//        IFileCreate fileCreate = this.getFileCreate();
//        List<FileOutConfig> fileOutConfigList = this.getFileOutConfigList();
//        Map<String, Object> map = this.getMap();
//    }
//
//
//    public static FileOutConfig fileOutConfig() {
//        FileOutConfig fileOutConfig = new FileOutConfig() {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                String comment = tableInfo.getComment();
//                return comment;
//            }
//        };
//        return fileOutConfig;
//    }
//}
//
//
////TODO velocity Freemarker Beetl三种模板引擎