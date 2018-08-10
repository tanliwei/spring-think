package cn.tanlw.spring.util;

import cn.tanlw.spring.util.entity.StudentA;
import cn.tanlw.spring.util.entity.StudentB;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @create 2018/7/31
 */
public class BeanUtilsTest {

    @Test
    public void testIntegerToInt(){
        StudentA a = new StudentA();
        a.setAge(10);
        StudentB b = new StudentB();
        BeanUtils.copyProperties(a,b);
        /**
         * Console:
         * b.getAge():10
         */
        System.out.println("b.getAge():"+b.getAge());
    }

    @Test
    public void testIntToInteger(){
        StudentB b = new StudentB();
        b.setAge(10);
        StudentA a = new StudentA();

        BeanUtils.copyProperties(b,a);
        /**
         * Console:
         * a.getAge():10
         */
        System.out.println("a.getAge():"+a.getAge());
    }

    @Test
    public void testBooleanToBool(){
        StudentA a = new StudentA();
        a.setAllow(true);
        StudentB b = new StudentB();
        BeanUtils.copyProperties(a,b);
        /**
         * Console:
         * org.springframework.beans.FatalBeanException: Could not copy property 'age' from source to target; nested exception is java.lang.IllegalArgumentException
         */
        System.out.println("b.isAllow():"+b.isAllow());
    }

    @Test
    public void testByteTobyte(){
        StudentA a = new StudentA();
        a.setGrade((byte)4);
        StudentB b = new StudentB();
        BeanUtils.copyProperties(a, b);
        /**
         * org.springframework.beans.FatalBeanException: Could not copy property 'age' from source to target; nested exception is java.lang.IllegalArgumentException
         */
        System.out.println(b.getGrade());
    }
}
