一、下载zookeeper

    进官网 https://zookeeper.apache.org/ 点击 Download，Download
    选择一个镜像地址(如：http://mirrors.shu.edu.cn/apache/zookeeper/)
    选择你喜欢的版本下载
    解压 进入zookeeper/conf 复制一份 zoo_sample.cfg 文件重命名为zoo.cfg
    zoo_sample.cfg 为配置模版，zoo.cfg 为配置文件
    返回zookeeper 进入bin 下启动 zkServer.cmd 或 zkServer.sh
    
二、下载dubbo-admin
    
    dubbo已经归apache管理，并改名为 incubator-dubbo
    从github 上 获取最新代码，存在两个分支，切换到2.5.x 分支
    这个分支有dubbo-admin代码，master分支暂时没有
    进入到dubbo-admin下用命令行执行 mvn package 打包
    在dubbo-admin下生成target，target里面有个dubbo-admin-2.5.10.war
    
三、下载Tomcat
     
     进入官网https://tomcat.apache.org/ 选择一个版本点击download
     选择喜欢的压缩包，下载后解压
     将dubbo-admin-2.5.10.war复制到webapp下，启动tomcat
     因为 zookeeper 可能会占用8080端口，导致tomcat启动失败
     需要修改zookeeper 配置添加 admin.serverPort=:port