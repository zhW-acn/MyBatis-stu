package dao;

import bean.relation.Order;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/09/22:12
 */
public interface OrderDao {

    List<Order> selectAllOrders();
}
