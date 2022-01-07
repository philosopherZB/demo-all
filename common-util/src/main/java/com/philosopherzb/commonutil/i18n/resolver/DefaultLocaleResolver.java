package com.philosopherzb.commonutil.i18n.resolver;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * internationalization parser
 *
 * @author philosopherZB
 * @date 2021/12/15
 */
public class DefaultLocaleResolver implements LocaleResolver {
    private static final String LANG = "Accept-Language";
    private final List<Locale> supportedLocales = new ArrayList<>(4);
    private final Map<String, Locale> supportedLocaleMaps = new HashMap<>();
    @Nullable
    private Locale defaultLocale;

    public DefaultLocaleResolver() {
    }

    public void setSupportedLocales(List<Locale> locales) {
        this.supportedLocales.clear();
        this.supportedLocales.addAll(locales);
        supportedLocaleMaps.clear();
        locales.forEach(locale -> {
            supportedLocaleMaps.put(locale.getLanguage() + "_" + locale.getCountry(), locale);
        });
    }

    public List<Locale> getSupportedLocales() {
        return this.supportedLocales;
    }

    public void setDefaultLocale(@Nullable Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    @Nullable
    public Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getHeader(LANG);
        Locale defaultLocale = this.getDefaultLocale();
        if (defaultLocale != null && request.getHeader(LANG) == null) {
            return defaultLocale;
        } else if (supportedLocaleMaps.containsKey(lang)) {
            // most sense
            return supportedLocaleMaps.get(lang);
        } else {
            //get locale from browser settings
            Locale requestLocale = request.getLocale();
            List<Locale> supportedLocales = this.getSupportedLocales();
            if (!supportedLocales.isEmpty() && !supportedLocales.contains(requestLocale)) {
                Locale supportedLocale = this.findSupportedLocale(request, supportedLocales);
                if (supportedLocale != null) {
                    return supportedLocale;
                } else {
                    return defaultLocale != null ? defaultLocale : requestLocale;
                }
            } else {
                return requestLocale;
            }
        }
    }

    @Nullable
    private Locale findSupportedLocale(HttpServletRequest request, List<Locale> supportedLocales) {
        Enumeration<Locale> requestLocales = request.getLocales();
        Locale languageMatch = null;

        Locale locale;
        label38:
        do {
            while (requestLocales.hasMoreElements()) {
                locale = (Locale) requestLocales.nextElement();
                if (supportedLocales.contains(locale)) {
                    continue label38;
                }

                if (languageMatch == null) {
                    Iterator var6 = supportedLocales.iterator();

                    while (var6.hasNext()) {
                        Locale candidate = (Locale) var6.next();
                        if (!StringUtils.hasLength(candidate.getCountry()) && candidate.getLanguage().equals(locale.getLanguage())) {
                            languageMatch = candidate;
                            break;
                        }
                    }
                }
            }

            return languageMatch;
        } while (languageMatch != null && !languageMatch.getLanguage().equals(locale.getLanguage()));

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locale) {
        throw new UnsupportedOperationException("Cannot change HTTP accept header - use a different locale resolution strategy");
    }
}
