import dao.OrderDao;
import dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/09/12:43
 */
@Slf4j
public class TestRelation {
    static SqlSession sqlSession = null;
    ProductDao productDao;
    OrderDao orderDao;
    @Before
    public void beforeTest(){
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("DB/mybatis-config.xml")).openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productDao = sqlSession.getMapper(ProductDao.class);
        orderDao = sqlSession.getMapper(OrderDao.class);
    }

    @Test
    public void selectAllProductsTest(){
        productDao.selectAllProducts().forEach(System.out::println);
    }

    @Test
    public void selectAllOrdersTest(){
        orderDao.selectAllOrders().forEach(System.out::println);
    }

}
