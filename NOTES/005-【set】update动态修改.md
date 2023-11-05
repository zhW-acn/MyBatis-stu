只修改需要修改的值，用set标签包裹所有字段。使用if拼接。每一个字段用`,`隔开，最后一个逗号自动删除

```xml
<update id="updateUser" parameterType="bean.User">
        update user
        <set>
            <if test="name!=null and name!=''">
                u_name = #{name},
            </if>
            <if test="passwd!=null and passwd!=''">
                u_passwd = #{passwd},
            </if>
            <if test="email!=null and email!=''">
                email = #{email},
            </if>
            <if test="birth!=null and birth!=''">
                birth = #{birth},
            </if>
        </set>
        where id=#{id}
    </update>
```