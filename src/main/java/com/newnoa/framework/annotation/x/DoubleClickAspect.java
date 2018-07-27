package com.newnoa.framework.annotation.x;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 重复点击
 * @create 2018/7/23
 */
@Aspect
@Component
public class DoubleClickAspect {

    private Map redisTemplate = new HashMap();

    @Pointcut("@annotation(com.newnoa.framework.annotation.x.DoubleClick)")
    public void doubleClickPointCut(){}

    @Before("doubleClickPointCut() && @annotation(doubleClick)")
    public void doubleClickCheck(JoinPoint point, DoubleClick doubleClick){

        Signature signature = point.getSignature();
        String fullMethodName = signature.getDeclaringTypeName() +"."+ signature.getName();
        int timeout = doubleClick.timeout();
        Object[] args = point.getArgs();
        String doubleClickKey;
        if (args == null || args.length == 0) {
            doubleClickKey = fullMethodName;
        } else {
            doubleClickKey = fullMethodName+ DigestUtils.md5DigestAsHex(JSON.toJSONBytes(args));
        }
        boolean isDoubleClick = redisTemplate.get(doubleClickKey) != null;
        if (isDoubleClick) {
            throw new RuntimeException("请勿重复点击");
        } else {
            redisTemplate.put(doubleClickKey, "");
        }
    }
}
