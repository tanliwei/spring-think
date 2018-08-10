package cn.tanlw.spring.test.service.impl;

import cn.tanlw.spring.test.dao.StudentMapper;
import cn.tanlw.spring.test.entity.Student;
import cn.tanlw.spring.test.entity.StudentDto;
import cn.tanlw.spring.test.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @InjectMocks
    private StudentService studentService = new StudentServiceImpl();

    @Mock
    private StudentMapper studentMapper;

    private static Student student = new Student();
    static {
        student.setId(123);
        student.setName("Jack");
        student.setAge(18);
    }


    @Before
    public void setUp(){

        /**
         * Student类要重写 hashCode 和 equals 方法
         */
        Mockito.when(studentMapper.findById(123)).thenReturn(student);
        Mockito.when(studentMapper.update(student)).thenReturn(true);
    }

    @Test
    public void findBydId() {
        Student student = studentMapper.findById(123);
        System.out.println(student.getName());
    }

    @Test
    public void update() {
        StudentDto dto = new StudentDto();
        dto.setAge(18);
        dto.setId(123);
        dto.setName("Jack");
        System.out.println(studentService.update(dto));;
    }
}
