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
