mapper标签

属性值 

namespace 描述这个mapper对应哪个dao接口，写全限定类名
<hr>

子标签

resultType 数据库列名与类的属性名的映射
```
<resultType>id="XXXmap，给resultMap定义唯一标识"  type="类"  >
    <result column="数据库列名" property="属性名"/>
```

select
```
<select id="方法名" resultType="返回类型，resultType中的id属性"    或者设置resultMap="resultType标签里的id属性"
```