# SSMLearn 项目介绍

参照尚硅谷的美年旅游项目实现，依赖的需要运行的外部组件有： 
- mysql
- zookeeper
- redis 

以上所有组件运行在WSL2上，其余开发和运行在本地执行


#  Pom中的依赖项的设置

- Pojo 依赖于Common
- Dao 依赖于 pojo
- Interface 依赖于 Dao 和 Pojo(去掉试试)
- Service 依赖于 Interface 和 Dao（去掉试试）
- Web 依赖于 Interface
- MoblieWeb同Web
- 

# 项目中各个组件
## Common
- 访问数据库的传递参数的entity类，可以序列化，用于和前端交互发送信息
- 常量类
- 公共工具类，如日期转换、发送短信、上传图片、读取和写Excel等
  
## Pojo

定义类数据库的对应的pojo类

## Dao 
- 定义了访问数据库的 Mybatias相关组件 spring整合mybatis
- Mybatis的实现定义interface以及对应的XML
- 配置文件中定义类扫描interface的路径,数据库的链接参数,以及spring整合Mybatis的配置

## Interface

- 定义的Service层的接口

## Quartz

- 例行任务执行服务器

## Service

- 定义的是Interface的实现，会在这里调用Dao层
- 将相应的服务注册到Dubbo 

## Web

- 定义的是Controller层，调用Service层的组件
- 消费Dubbo上的相应的服务
- 分为业务Controller和权限控制两部分



# Mybatias

1. 使用Spring整合Mybatias，主要在配置文件中配置SqlSessionFactoryBean，同时配置MapperScannerConfigurer指定需要扫描的接口
2. 涉及到的相关用法
   - useGeneratedKeys
   - 使用where和if 标签来解决条件语句有0-n个时and的情况  set和if来解决插入任意个列的情况
   - useGeneratedKeys	（仅适用于 insert 和 update）这会令 MyBatis 使用 JDBC 的 getGeneratedKeys 方法来取出由数据库内部生成的主键（比如：像 MySQL 和 SQL Server 这样的关系型数据库管理系统的自动递增字段），默认值：false。-
   - keyProperty	（仅适用于 insert 和 update）指定能够唯一识别对象的属性，MyBatis 会使用 getGeneratedKeys 的返回值或 insert 语句的 selectKey 子元素设置它的值，默认值：未设置（unset）。如果生成列不止一个，可以用逗号分隔多个属性名称。
   - 传入和返回的结果为map  会自动完成映射



# Quartz 

1. 使用Spring整合Quartz，定义我们自定义job的class的bean，然后定义一个crontab格式的trigger，然后将该trigger注册到scheduler开始运行
2. 自定义job class 并且实现对应的函数



# Dubbo

1. Provider方： 也就是Service模块，需要在每个ServiceImpl实现的时候使用@Service注解来表明提供服务的类
2. Consumer方： 定义一个Provider对象，时候用@Reference表示 这是一个service



# SpringSecurity

1. 和SpringMvc整合在一起，在web.xml中设置必须的Filter，将请求发送给Controller之前进行权限控制
2. 通过注释的方式，对Controller中进行相关请求的权限进行了设置
3. 自定义了帐户密码通过后的认证逻辑，认证获获取用户的id，然后通过userid获取roleid，然后获取的role对应的权限和可以访问的元素，然后将这些信息提供给SpringSecurity 来判断用户是否有权限进行相关的请求
