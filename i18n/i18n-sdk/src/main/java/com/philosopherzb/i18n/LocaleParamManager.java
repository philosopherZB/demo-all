package com.philosopherzb.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 统一管理LOCALES
 *
 * @author philosopherZB
 * @date 2022/1/6
 */
class LocaleParamManager {
    /**
     * 加载 locale
     */
    static List<Locale> LOCALES = new ArrayList<>();

    static {
        LOCALES.add(Locale.CHINA);
        LOCALES.add(Locale.US);
    }
}
