1. Failed to execute goal org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:deploy (default-cli) on project Web: Cannot invoke Tomcat manager

    - 参考 ： https://localcoder.org/mvn-tomcat7deploy-cannot-invoke-tomcat-manager-broken-pipe

2. tomcat显示乱码的问题   
    - windows 关闭 UTF-8  实验特性
   
3. Failed to meta-introspect annotation interface org.springframework.web.bind.annotation.RequestBody
    - 查阅资料显示显示是dubbo的消费端有问题，手动登录zk看到服务提供端在zk注册了，后来排查发现zk的地址写的有问题
    - com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Could not create connection to database serve
        - 

