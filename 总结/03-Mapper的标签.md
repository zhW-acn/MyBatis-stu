mapper约束
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.9//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="xxx">
</mapper>
```
mapper的namespace 属性用于指定持久化类或接口
<hr>
子标签 CRUD->insert select update delete

> id 指定类或接口的方法名。调用方法时执行子标签内的SQL
> 
> parameterType 参数类型。使用[typeAlias](02-mybatis-config的标签.md#typealiases)以简化限定名