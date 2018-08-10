package cn.tanlw.spring.test.service.impl;

import cn.tanlw.spring.test.dao.StudentMapper;
import cn.tanlw.spring.test.entity.Student;
import cn.tanlw.spring.test.entity.StudentDto;
import cn.tanlw.spring.test.service.StudentService;
import org.springframework.beans.BeanUtils;

/**
 * @create 2018/8/2
 */
public class StudentServiceImpl implements StudentService {

    StudentMapper studentMapper;

    @Override
    public Student findBydId(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public Boolean update(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        return studentMapper.update(student);
    }
}
