package spring.think.ch06.messageFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * IDEA 修改 properties 文件编码
 * File -> Settings -> File Encodings -> Default encoding for properties file -> UTF-8
 * @Creator Tan Liwei
 * @Date 2018/10/4 20:32
 */
public class Main {
    public static void main(String[] args) {
        String[] configs = {"ch06/applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        //1直接通过容器访问国际化信息
        Object[] params = {"John", new GregorianCalendar().getTime()};
        /**
         * Console:
         * test
         * 测试
         */
        String str1 = ctx.getMessage("test", params, Locale.US);
        String str2 = ctx.getMessage("test", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }
}
