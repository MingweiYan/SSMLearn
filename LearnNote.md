# Day1

--- 
## 架构演变 
- 单体应用 
  - 所有的内容放在一个项目中，只能使用单一语言开发，扩展需要增加服务器，修改一次影响全局，部署慢
  - 适用于小项目
- 垂直架构
  - 根据业务将大的项目拆分为多个小项目，还是集中在一个项目里，项目之间存在冗余（多个大的项目拆分出来的子项目功能可能重复），同样需要整个项目部署
- SOA架构  Service-Oriented Architecture
  - 将不同的功能抽象为不同的服务，服务之间通过ESB（企业服务总线）来进行通信
  - 服务之间存在耦合，服务抽取的粒度大
- 微服务
  - 将功能拆成不同的微服务，
  - 缺点是服务粒度过小，服务过多
  
--- 
## 构建项目

1. 新建父项目，设置pom文件
2. 新建module Common，设置pom文件
3. 新建module Pojo,设置pom文件
4. 新建module Dao,设置pom文件,添加log4j,mybatis，等配置文件
5. 新建module Interface,设置pom文件
6. 新建module Service,设置pom文件,设置配置文件
7. 新建module Web,设置pom文件


# Day3 

## 构建项目

1. 创建三张表
2. 创建pojo类、常量类

## 项目开发（自由行）

1. 新建Controller/Service/Dao 等组件

2. 新增自由行的相关开发


## 一些记录

快捷键  
  - ctrl + alt + b 跳转到实现类? 
  - ctrl + i 实现重写的方法
  - 安装alt然后拖动鼠标选中多行，ctrl + w 选中一个词  ctrl + backspace 缩减到一行



# Day4 
1. 完成自由行的开发
2. 开始跟团游的开发