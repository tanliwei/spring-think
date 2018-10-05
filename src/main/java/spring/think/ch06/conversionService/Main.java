package spring.think.ch06.conversionService;

import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 21:57
 */
public class Main {
    @Test
    public void testStringToPhoneNumberConvert(){
        DefaultConversionService conversionService = new DefaultConversionService();
        //书中例子不完整
//        conversionService.addConverter(new StringToPhoneNumberConverter());
    }
}
