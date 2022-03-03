package com.maple.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringBeanUtils {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringBeanUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String var1) throws BeansException {
        return applicationContext.getBean(var1);
    }

    public static <T> T getBean(String var1, Class<T> var2) throws BeansException {
        return applicationContext.getBean(var1, var2);
    }
}
