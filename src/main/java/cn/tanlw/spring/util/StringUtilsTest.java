package cn.tanlw.spring.util;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @create 2018/7/26
 */
public class StringUtilsTest {

    @Test
    public  void collTest(){
        Map map = new HashMap<>();
        map.put("a","abc");
        map.put("a2","abc");
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        String res = StringUtils.collectionToCommaDelimitedString(list);
        System.out.println("res:"+res);

        String[] revert = StringUtils.commaDelimitedListToStringArray(res);
//        Arrays.stream(revert).
        Arrays.stream(revert).forEach( i -> System.out.println(i));
//        Arrays.stream(revert).forEach(String::toString);
        Arrays.stream(revert).forEach(System.out::println);
    }
}
