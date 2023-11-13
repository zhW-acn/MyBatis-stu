import bean.Course;
import bean.Student;
import dao.CourseDao;
import dao.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/12/16:31
 */

@Slf4j
public class MyTest {
    static SqlSession sqlSession;
    static StudentDao studentDao;
    static CourseDao courseDao;

    @Before
    public void connectionTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
        courseDao = sqlSession.getMapper(CourseDao.class);

    }

    @Test
    public void selectAllStudents() {
        List<Student> students = studentDao.selectAllStudents();
        students.forEach(System.out::println);
    }

    @Test
    public void selectAllCourses(){
        List<Course> courses = courseDao.selectAllCourses();
        courses.forEach(System.out::println);
    }

}
