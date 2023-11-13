```java
public class test {
    public static void main(String[] args) {
        
        String resource = "DB/mybatis-config.xml";
        
        try (InputStream is = Resources.getResourceAsStream(resource)) {// 实现了closeable
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();// autocommit缺省为false

            xxxDao = sqlSession.getMapper(xxxDao.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```