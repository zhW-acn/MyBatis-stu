package utils;

import bean.User;

import java.util.HashMap;

/**
 * @Description: SQL拼接
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
    public String selectUserByCond(HashMap map) {
        String sql = "select * from user where 1=1 ";
        if (map.get("name") != null && !"".equals(map.get("name"))) {
            sql += " and u_name = #{name}";
        }

        if (map.get("passwd") != null && !"".equals(map.get("passwd"))) {
            sql += " and u_passwd = #{passwd}";
        }
        return sql;
    }

    public String updateUser(HashMap map) {
        String sql = "update user set ";
        if (map.get("name") != null && map.get("name") != "") {
            sql += "u_name = #{name},";
        }
        if (map.get("passwd") != null && map.get("passwd") != "") {
            sql += "u_passwd = #{passwd},";
        }
        if (map.get("email") != null && map.get("email") != "") {
            sql += "email = #{email},";
        }
        if (map.get("birth") != null && map.get("birth") != "") {
            sql += "birth = #{birth}";
        }

        return sql;
    }
}
