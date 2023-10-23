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
     * 查询一个user id为1，
     *
     * @return User
     */
    @Select("select * from user where id = #{arg0}")
    User selectUserById(String id);


    @SelectProvider(type = SqlProvider.class, method = "creatSql")
    List<User> selectUserByNameAndPasswdUseProvider(HashMap map);
}
