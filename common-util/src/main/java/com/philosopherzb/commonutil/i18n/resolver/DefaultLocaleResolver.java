package com.philosopherzb.commonutil.i18n.resolver;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * internationalization parser
 *
 * @author philosopherZB
 * @date 2021/12/15
 */
public class DefaultLocaleResolver implements LocaleResolver {
    /**
     * Request header field
     */
    private static final String LANG = "lang";

    /**
     * session
     */
    private static final String LANG_SESSION = "lang_session";

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lang = httpServletRequest.getHeader(LANG);
        Locale locale = Locale.getDefault();
        if (StringUtils.isNotBlank(lang)) {
            String[] language = lang.split("_");
            locale = new Locale(language[0], language[1]);

            HttpSession session = httpServletRequest.getSession();
            session.setAttribute(LANG_SESSION, locale);
        } else {
            HttpSession session = httpServletRequest.getSession();
            Locale localeInSession = (Locale) session.getAttribute(LANG_SESSION);
            if (localeInSession != null) {
                locale = localeInSession;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
