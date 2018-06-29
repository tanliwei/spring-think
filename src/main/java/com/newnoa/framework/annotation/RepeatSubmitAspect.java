package com.newnoa.framework.annotation;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author longyang.lin
 * @description
 * @create 2018年06月25日19:07
 */
@Aspect
@Component
public class RepeatSubmitAspect {
//    @Autowired
    private Map redisTemplate = new HashMap();

    @Pointcut("@annotation(com.newnoa.framework.annotation.RepeatSubmit)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doRepeatSubmitValid(ProceedingJoinPoint pjp) throws Throwable {
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("这种注释只能用于方法!!");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        if (currentMethod != null) {
            String keyStr = DigestUtils.md5DigestAsHex(JSON.toJSONString(pjp.getArgs()).concat(currentMethod.getName()).getBytes());
            if (redisTemplate.containsKey(keyStr)) {
                throw new RuntimeException("请勿重复点击！");
            } else {
                System.out.println("第一次点击");
                redisTemplate.put(keyStr, "");
            }
        }
        return pjp.proceed();
    }
}
