## 基本流程

获取sqlSession
```java
@Slf4j
public class TestMyBatis {
    @annotationTest
    public void test() throws IOException {
        // 指定配置文件
        String res = "mybatis-config.xml";
        // 获得输入流
        InputStream inputStream = Resources.getResourceAsStream(res);
        // 通过输入流构建factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // factory打开session
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){// 实现了closeable
            // 业务处理，通过sqlSession获得接口对象（注册mapper）
            UserDao mapper = sqlSession.getMapper(UserDao.class);
        }

    }

}

```
   每一个请求进来都会从factory里获得一个sqlSession，每个请求拿到各自的请求里执行各自的业务。所以不要放在共享的地方。所以这个类是线程不安全的