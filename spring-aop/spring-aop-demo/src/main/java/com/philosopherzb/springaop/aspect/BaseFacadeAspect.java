package com.philosopherzb.springaop.aspect;

import com.philosopherzb.springaop.util.Result;
import com.philosopherzb.springaop.util.ResultEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@Component
@Aspect
public class BaseFacadeAspect {
    private static final Logger logger = LoggerFactory.getLogger(BaseFacadeAspect.class);

    @Around(value = "com.philosopherzb.springaop.pointcut.PointCut.doGateway()")
    public Object around(ProceedingJoinPoint pjp){
        logger.info("BaseFacadeAspect.around begin execute call gateway method");
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error("BaseFacadeAspect.around occur exception, e={}",throwable);
            return Result.newFailure(ResultEnum.SYSTEM_ERROR);
        }
    }
}
