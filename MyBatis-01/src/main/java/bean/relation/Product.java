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
public class Product {
    int id;
    String pName;

    List<Order> orders;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
