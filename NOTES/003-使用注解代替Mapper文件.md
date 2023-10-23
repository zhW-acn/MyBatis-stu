1. 在dao接口层定义方法
2. 在方法上添加注解，注解里直接填写SQL语句
    ```
       @Select("select * from user where id = 1")
        User selectUserById();
    //带参数
    @Select("select * from user where id = #{arg0}")//    使用#{argx}占位
    User selectUserById(String id);
    ```
3. 没有config文件的话手动添加
    `sqlSessionFactory.getConfiguration().addMapper(XXX.class);`
4. 解决列名映射
    ```
       @Results=({  
       @Result(column = "t_name", property = "name") 
       ...
       }) 
    ```
5. 使用不定参数查询
    - 新建SqlProvider工具类，用于动态拼接SQL。
    - 在需要拼接SQL的方法上添加注解@SqlProvider(type=工具类的class, method="工具类里对应的方法")
    - 使用Map来给参数赋值：dao接口在定义方法时需要一个Map集合。工具类通过这个Map集合拼接SQL。