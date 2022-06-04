1. Pom中的依赖项的设置

- Pojo 依赖于Common
- Dao 依赖于 pojo
- Interface 依赖于 Dao 和 Pojo(去掉试试)
- Service 依赖于 Interface 和 Dao（去掉试试）
- Web 依赖于 Interface
 
2. 项目中各个组件
- Common定义了访问数据库的传递参数的entity类，和对应的常量类
- Pojo定义类数据库的对应的pojo类
- Dao 定义了访问数据库的 Mybatias相关组件 spring整合mybatis
- Interface定义的时Service层的接口
- Service定义的是Interface的实现，会在这里调用Dao层
- Web定义的是Controller层