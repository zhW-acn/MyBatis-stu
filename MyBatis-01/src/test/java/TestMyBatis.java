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
 * @date: 2023/10/22/18:43
 */
@Slf4j
public class TestMyBatis {
    static SqlSession sqlSession;
    UserDao userDao;
    //
    @Before
    public void before() {
        String resource = "DB/mybatis-config.xml";

        try (InputStream is = Resources.getResourceAsStream(resource)) {// 实现了closeable
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();

            userDao = sqlSession.getMapper(UserDao.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 连接测试
    @Test
    public void test() throws IOException {
//        // 指定配置文件
//        String res = "DB/mybatis-config.xml";
//        // 获得输入流
//        InputStream inputStream = Resources.getResourceAsStream(res);
//        // 通过输入流构建factory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // factory打开session
            // 业务处理，通过sqlSession获得接口对象（注册mapper）
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            log.debug("mapper.selectAllUser() is [{}]", mapper.selectAllUser());


    }


    @Test
    public void annotationTest() {
        log.debug("userDao.selectUser() is [{}]", userDao.selectUserById("1"));

    }

    @Test
    public void providerTest() {
        HashMap hashMap = new HashMap();
        hashMap.put("name","1");
        hashMap.put("passwd","1");
        log.debug("userDao.selectUser() is [{}]", userDao.selectUserByNameAndPasswdUseProvider(hashMap));

    }

    @Test
    public void condTest(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","安藤大和");
        hashMap.put("passwd","OuDcCOLIqK");

        List<User> users = userDao.selectUserByCond(hashMap);
        users.forEach(System.out::println);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1);
        user.setName("动态修改");
        userDao.updateUser(user);
//        sqlSession.commit();
    }


    @Test
    public void selectUsersById(){
        int[] ids = {1,2,3,4,5,123,0,6};
        List<User> users = userDao.selectUsersById(ids);
        users.forEach(System.out::println);
    }
}
