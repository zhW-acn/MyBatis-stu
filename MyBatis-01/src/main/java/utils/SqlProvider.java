package utils;

import bean.User;

import java.util.HashMap;

/**
 * @Description: SQL工具类
 * @author: acn
 * @date: 2023/10/23/22:07
 */
public class SqlProvider {

    /**
     * 拼接SQL
     *
     * @param map HashMap
     * @return SQL
     */
    public String creatSql(HashMap map) {
        String sql = "select * from user where 1=1 ";
        if (map.get("name") != null && !"".equals(map.get("name"))) {
            sql += " and u_name = #{name}";
        }

        if (map.get("passwd") != null && !"".equals(map.get("passwd"))) {
            sql += " and u_passwd = #{passwd}";
        }
        return sql;
    }
}
