package com.philosopherzb.springaop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
public class PointCut {

    /**
     * execution(
     *     modifier-pattern?  //修饰符
     *     ret-type-pattern  //返回类型
     *     declaring-type-pattern?  //方法模式
     *     name-pattern(param-pattern)  //参数模式
     *     throws-pattern?  //异常模式
     * )
     *
     * 整个表达式可以分为五个部分：
     *
     *  1、execution(): 表达式主体。
     *
     *  2、第一个*号：表示返回类型，*号表示所有的类型。
     *
     *  3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
     *
     *  4、第二个*号：表示类名，*号表示所有的类。
     *
     *  5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     *  pointcut("execution(* com.sample.service.impl..*.*(..))")
     */
    @Pointcut(value = "execution(* com.philosopherzb.springaop.service.impl..UserGatewayServiceImpl.callGateway(..))")
    public void doGateway(){}
}
