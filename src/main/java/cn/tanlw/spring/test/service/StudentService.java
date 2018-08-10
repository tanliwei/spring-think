package cn.tanlw.spring.test.service;

import cn.tanlw.spring.test.entity.Student;
import cn.tanlw.spring.test.entity.StudentDto;

/**
 * @create 2018/8/2
 */
public interface StudentService {
    Student findBydId(Integer id);

    Boolean update(StudentDto student);
}
