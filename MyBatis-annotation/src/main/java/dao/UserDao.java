package dao;

import bean.Clazz;
import bean.User;
import org.apache.ibatis.annotations.*;
import utils.SqlProvider;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/10/22/20:46
 */
public interface UserDao {// 没有实现类

    /**
     * 查询所有User
     */
    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "u_name",property = "name"),
            @Result(column = "u_passwd",property = "passwd"),
            @Result(column = "email",property = "email"),
            @Result(column = "birth",property = "birth")
    })
    List<User> selectAllUser();

    /**
     * 使用map实现查询不定参数
     * @param hashMap
     * @return
     */

    @SelectProvider(type =SqlProvider.class,method = "selectUserByCond")
    List<User> selectUserByCond(HashMap hashMap);

    /**
     * 只修改参数对象中改变的字段
     * @param user
     */
    @UpdateProvider(type = SqlProvider.class,method = "updateUser")
    void updateUser(User user);

    /**
     * 通过id数组循环查询
     * 这种场景是查询某个字段在一个集合中的所有数据
     * @param ids
     * @return
     */
    @Select("select * from user where ")
    List<User> selectUsersById(int[] ids);


    /**
     * 通过班级名查找该班级下的所有学生
     * @param clazzName
     * @return
     */
    List<User> selectUsersByClazzName(String clazzName);


    List<User> selectUsersByIdIncludeClass();

    /**
     * 查询一个user id为1，
     *
     * @return User
     */
    @Select("select * from user where id = #{arg0}")
    User selectUserById(int id);


    /**
     * 手动拼串
     * @param map
     * @return
     */
    @SelectProvider(type = SqlProvider.class, method = "selectUserByCond")
    List<User> selectUserByNameAndPasswdUseProvider(HashMap map);
}
