package cn.tanlw.spring.test.dao;

import cn.tanlw.spring.test.entity.Student;

/**
 * @create 2018/8/2
 */
public interface StudentMapper {
    Student findById(Integer id);

    Boolean update(Student student);
}
