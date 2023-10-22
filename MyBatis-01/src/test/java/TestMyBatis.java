import dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/10/22/18:43
 */
@Slf4j
public class TestMyBatis {
    @Test
    public void test() throws IOException {
        // 指定配置文件
        String res = "DB/mybatis-config.xml";
        // 获得输入流
        InputStream inputStream = Resources.getResourceAsStream(res);
        // 通过输入流构建factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // factory打开session
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){// 实现了closeable
            // 业务处理，通过sqlSession获得接口对象（注册mapper）
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            log.debug("mapper.selectAllUser() is [{}]", mapper.selectAllUser());
        }

    }

}
