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

# CRUD->insert select update delete
## 属性
- id 

    指定类或接口的方法名。调用方法时执行子标签内的SQL
- parameterType 

    参数类型。使用[typeAlias](02-mybatis-config的标签.md#typealiases)以简化限定名
- resultType&resultMap
    
    返回类型&返回映射。返回类型只能指定类型；返回映射可以指定列与属性的映射关系，resultMap的值应填写一个resultMap的id

# resultMap
## 属性
- id
    
    resultMap的唯一标识
- type

    resultMap的返回类型，可以与typeAlias简化全限定类名
## 子标签
- result
    
    指定**column**与**property**的关系映射

    - column：列名
    - property：属性名
    - javaType：全限定类名。指定返回的java类型
  
- association
    
    多对一关系映射。属性同resultMap。用于指定**多对一**关系的**一**
    - select：指定查询的那个列名的select标签id。
    - 有了select的指定，association就无需配置列属映射

- collection

    一对多关系映射，属性也和resultMap一样。用于指定**一对多**关系的**多**
    - oType：指定返回的集合是什么Java类型
    - 配置了resultMap属性就无需配置列属映射