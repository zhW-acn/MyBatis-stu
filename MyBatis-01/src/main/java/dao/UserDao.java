package dao;

import bean.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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
    List<User> selectAllUser();

    /**
     * 使用map实现查询不定参数
     * @param hashMap
     * @return
     */
    List<User> selectUserByCond(HashMap hashMap);

    /**
     * 只修改参数对象中改变的字段
     * @param user
     */
    void updateUser(User user);

    /**
     * 通过id数组循环查询
     * 这种场景是查询某个字段在一个集合中的所有数据
     * @param ids
     * @return
     */
    List<User> selectUsersById(int[] ids);



    List<User> selectUsersByIdIncludeClass();

    /**
     * 查询一个user id为1，
     *
     * @return User
     */
    @Select("select * from user where id = #{arg0}")
    User selectUserById(String id);


    /**
     * 手动拼串
     * @param map
     * @return
     */
    @SelectProvider(type = SqlProvider.class, method = "creatSql")
    List<User> selectUserByNameAndPasswdUseProvider(HashMap map);
}
