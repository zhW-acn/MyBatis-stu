package bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/10/22/19:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    int id;
    String name;
    String passwd;
    String email;
    String birth;

    Clazz clazz;
}
