1. 利用HashMap作为参数去查询
   ``` java 
    /**
    * 使用map实现查询不定参数
    * @param hashMap
    * @return
      */
   List<User> selectUserByCond(HashMap hashMap);
   ```
2. 将要查询的参数put进map
3. mapper里的配置
    ```xml
    <select id="selectUserByCond" resultMap="UserMap">
    select * from user where 1=1
    <if test="name!=null and name!=''">
        and u_name = #{name}
    </if>
    <if test="passwd!=null and passwd!=''">
        and u_passwd = #{passwd}
    </if>
    <if test="email!=null and email!=''">
        and email = #{email}
    </if>
    <if test="birth!=null and birth!=''">
        and birth = #{birth}
    </if>
    </select>
    ```
    **ATTENTION**<br>
    - where后先拼一个true条件以方便拼接后面的and
    - if里判断的是map里的键是否为空和空串
    - 如果不是，则拼接其里面的字符串。注意里面赋值的是数据库的列，与结果映射无关，必须填数据库的列名


<hr>

或使用trim标签。
* prefix：在生成的 SQL 片段开头添加的前缀
* prefixOverrides：如果test里的表达式为真，就删除该if标签下的`and`字符串

```xml
<select id="selectUserByCond" resultMap="UserMap">
        select * from user
        <trim prefix="where" prefixOverrides="and">
            <if test="name!=null and name!=''">
                u_name = #{name}
            </if>
            <if test="passwd!=null and passwd!=''">
                and u_passwd = #{passwd}
            </if>
            <if test="email!=null and email!=''">
                and email = #{email}
            </if>
            <if test="birth!=null and birth!=''">
                and birth = #{birth}
            </if>
        </trim>
</select>
```

* 与之对应的是suffix

```xml
<select id="selectUserByCond" resultMap="UserMap">
   select * from user
   <trim prefix="where" suffixOverrides="and">
      <if test="name!=null and name!=''">
         u_name = #{name} and
      </if>
      <if test="passwd!=null and passwd!=''">
         u_passwd = #{passwd} and
      </if>
      <if test="email!=null and email!=''">
         email = #{email} and
      </if>
      <if test="birth!=null and birth!=''">
         birth = #{birth}
      </if>
   </trim>
</select>
```