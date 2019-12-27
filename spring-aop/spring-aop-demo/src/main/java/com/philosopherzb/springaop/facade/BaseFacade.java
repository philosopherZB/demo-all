package com.philosopherzb.springaop.facade;

import com.philosopherzb.springaop.dto.ApiRequest;
import com.philosopherzb.springaop.util.Constant;
import com.philosopherzb.springaop.util.Result;
import com.philosopherzb.springaop.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
