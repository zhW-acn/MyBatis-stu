package dao;

import bean.Clazz;

import java.util.List;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/05/22:19
 */
public interface ClazzDao {

    /**
     * 查询所有的班级信息（包括每个班级下有哪些学生）
     * @return
     */
    List<Clazz> selectAllClazz();

    /**
     * 根据班级编号查询班级信息
     * @return
     */
    Clazz selectAllClazzById(int id);
}
