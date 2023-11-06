import bean.User;
import dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/06/20:36
 */
@Slf4j
public class annotationTest {
    SqlSession sqlSession;
    UserDao userDao;

    @Before
    public void connectionTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("DB/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 手动注册mapper文件
        sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }


    @Test
    public void Test() {
        List<User> users = userDao.selectAllUser();
        users.forEach(System.out::println);
    }

    @Test
    public void selectUserByIdTest(){
        User user = userDao.selectUserById(3);
        System.out.println(user);
    }

    @Test
    public void selectUserByCondTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","青木大和");
        List<User> users = userDao.selectUserByCond(map);
        users.forEach(System.out::println);
    }
}
