package dao;

import bean.Course;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/13/13:25
 */
public interface CourseDao {

    List<Course> selectAllCourses();
}
