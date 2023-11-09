package bean.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/09/21:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    int id;
    String oName;

    List<Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", oName='" + oName + '\'' +
                ", products=" + products +
                '}';
    }
}
