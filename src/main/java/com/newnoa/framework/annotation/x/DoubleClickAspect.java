package com.newnoa.framework.annotation.x;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 重复点击
 *
 * @create 2018/7/23
 */
@Aspect
@Component
public class DoubleClickAspect {

    private Map redisTemplate = new HashMap();

    @Pointcut("@annotation(com.newnoa.framework.annotation.x.DoubleClick)")
    public void doubleClickPointCut() {
    }

    @Before("doubleClickPointCut() && @annotation(doubleClick)")
    public void doubleClickCheck(JoinPoint point, DoubleClick doubleClick) {
        String authorization = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
        Signature signature = point.getSignature();
        String fullMethodName = signature.getDeclaringTypeName() + "." + signature.getName();
        int timeout = doubleClick.timeout();
        Object[] args = point.getArgs();
        StringBuilder doubleClickKey = new StringBuilder();
        if (args == null || args.length == 0) {
            doubleClickKey.append(fullMethodName);
        } else {
            doubleClickKey.append(fullMethodName).append(DigestUtils.md5DigestAsHex(JSON.toJSONBytes(args)));
        }
        doubleClickKey.append(authorization);
        boolean isDoubleClick = redisTemplate.get(doubleClickKey) != null;
        if (isDoubleClick) {
            throw new RuntimeException("请勿重复点击");
        } else {
            redisTemplate.put(doubleClickKey, "");
        }
    }
}
