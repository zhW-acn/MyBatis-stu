```xml
<select id="selectUsersById" resultMap="UserMap" parameterType="int">
        select * from user where id in
        <foreach collection="arg0" item="ids" open="(" close=")" separator=",">
            #{ids}
        </foreach>
</select>
```

* collection：参数列表
* items:列表中的每一项
* open:开头拼接
* close:结尾拼接
* separator:每一项以什么字符串分割