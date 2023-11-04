mapper标签

属性值 

namespace 描述这个mapper对应哪个dao接口，写全限定类名
<hr>

子标签

resultMap 数据库列名与类的属性名的映射
```
<resultMap>id="XXXmap，给resultMap定义唯一标识"  type="类"  >
    <result column="数据库列名" property="属性名"/>
```

select
```
<select id="方法名" resultType="返回类型，resultType中的id属性"    或者设置resultMap="resultType标签里的id属性"
```

insert
```
只有一个参数，可以不指定参数类型，多个参数不指定parameterType。
而是通过#{arg0}，#{arg1}这种按参数位置来赋值的方式；
或者封装成对象或使用map集合

parameterType="参数的类"
使用#{}占位符填充属性值
insert into table values(#{username},#{password})
```