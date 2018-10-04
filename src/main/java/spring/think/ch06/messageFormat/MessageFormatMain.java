package spring.think.ch06.messageFormat;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 20:24
 */
public class MessageFormatMain {
    public static void main(String[] args) {
        //1 信息格式化串
        String pattern1 = "{0}, 你好! 你于{1}在工商银行存入{2}元";
        String pattern2 = "At {1,time,short} On {1,date,long} , {0} paid {2, number,  currency}.";

        //2用于动态替换占位符的参数
        Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};

        //3还是要默认本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1, params);

        //4使用指定的本地化对象格式化信息
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        /**
         * Console:
         * John, 你好! 你于18-10-4 下午8:29在工商银行存入1,000元
         * At 8:29 PM On October 4, 2018 , John paid $1,000.00.
         */
        System.out.println(msg1);
        System.out.println(msg2);
    }
}
