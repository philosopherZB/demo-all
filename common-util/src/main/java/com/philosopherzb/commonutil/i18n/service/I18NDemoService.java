package com.philosopherzb.commonutil.i18n.service;

import com.philosopherzb.commonutil.i18n.util.PropertiesTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2021/12/15
 */
@Service
public class I18NDemoService {

    @Resource
    private PropertiesTools propertiesTools;

    public String getByName(String name) {
        return propertiesTools.getProperties(name);
    }

}

