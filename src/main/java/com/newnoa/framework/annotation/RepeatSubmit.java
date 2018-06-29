package com.newnoa.framework.annotation;

import java.lang.annotation.*;

/**
 * @author longyang.lin
 * @description
 * @create 2018年06月25日19:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface RepeatSubmit {
}
