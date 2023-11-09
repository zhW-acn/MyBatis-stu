package dao;

import bean.relation.Product;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/09/22:12
 */
public interface ProductDao {

    List<Product> selectAllProducts();
}
