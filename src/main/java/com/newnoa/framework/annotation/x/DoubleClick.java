package com.newnoa.framework.annotation.x;

import java.lang.annotation.*;

/**
 * @create 2018/7/23
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleClick {
    int timeout() default 3;
}
