package dao;

import bean.User;

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
    List<User>selectAllUser();
}
