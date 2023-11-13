package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/13/13:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    int cId;
    String cName;

    List<Student> students;
}
