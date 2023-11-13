package bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/12/15:59
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    int id;
    String sName;

    List<Course> courses;
}
