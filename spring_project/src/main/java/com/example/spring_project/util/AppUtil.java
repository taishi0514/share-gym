package com.example.spring_project.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class AppUtil {

    public static String getMessage(MessageSource messageSource, String messageId, Object... params) {
		return messageSource.getMessage(messageId,params, Locale.JAPANESE);
	}

    public static String addWildcard(String param) {
		return "%" + param + "%";
	}
    
}
