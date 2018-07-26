package com.darrenfang.commons.validation.validators;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

import javax.validation.MessageInterpolator;
import java.util.Locale;

public class LocalizedMessageInterpolator implements MessageInterpolator {
    private MessageInterpolator defaultInterpolator;
    private Locale defaultLocale;

    public LocalizedMessageInterpolator(MessageInterpolator interpolator, Locale locale) {
        this.defaultLocale = locale;
        this.defaultInterpolator = interpolator;
    }

    public LocalizedMessageInterpolator(Locale locale) {
        this.defaultLocale = locale;
        this.defaultInterpolator = new ResourceBundleMessageInterpolator();
    }

    /**
     * 将用户的 locale 信息传递给消息解释器，而不是使用默认的 JVM locale 信息
     */
    @Override
    public String interpolate(String message, Context context) {
        return defaultInterpolator.interpolate(message, context, this.defaultLocale);
    }

    @Override
    public String interpolate(String message, Context context, Locale locale) {
        return defaultInterpolator.interpolate(message, context, locale);
    }
}
