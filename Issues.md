1. Failed to execute goal org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:deploy (default-cli) on project Web: Cannot invoke Tomcat manager

    - 参考 ： https://localcoder.org/mvn-tomcat7deploy-cannot-invoke-tomcat-manager-broken-pipe

2. tomcat显示乱码的问题   
    - windows 关闭 UTF-8  实验特性
   
3. Failed to meta-introspect annotation interface org.springframework.web.bind.annotation.RequestBody
   - 查阅资料显示显示是dubbo的消费端有问题，手动登录zk看到服务提供端在zk注册了，后来排查发现zk的地址写的有问题
      
4. com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Could not create connection to database serve
   - 查阅资料看到可能是Mysql的版本和设置的驱动和pom中的版本不一致导致  参考https://blog.csdn.net/weixin_45063658/article/details/122009603 修改
    
5.  org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.example.dao.TravelItemDao.add, dubbo version: 2.6.0, current host: 127.0.0.1
    org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.example.dao.TravelItemDao.add
    - 查阅资料表示这种错误是定义的dao的接口和对应的mybatis的xml名字或者命名空间对不上导致的，经过排查后发现没有这个问题，最后发现是放置XML文件的路径不对，将路径修改为package相同的路径就OK了
    - 一个错误的可能是 XML 和 Dao对应Class的文件名字对应不一致
    
6. org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException: Fail to save: an error occurs  
   - 查阅资料 如果要针对同一个excel文件进行多次读写，在根据这个文件再次创建Workbook 对象的时候一定要使用流，而不是使用File，将直接从File创建改成从输入流创建就OK了，
     参考：  https://blog.csdn.net/m0_37607945/article/details/107270405