package com.philosopherzb.springaop.facade;

import com.philosopherzb.springaop.util.Result;
import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
public abstract class BaseFacade {
    protected Map<String, Function<String,Result>> functionMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void startInit(){
        this.init();
    }

    protected abstract void init();

}
