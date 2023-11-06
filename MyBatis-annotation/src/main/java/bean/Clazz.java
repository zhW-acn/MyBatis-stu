package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/05/21:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {

     int id;
     String className;
     List<User> users;// 班级下的所有人
}
