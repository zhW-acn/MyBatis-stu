package dao;

import bean.Student;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/12/16:04
 */
public interface StudentDao {
    List<Student> selectAllStudents();
}
