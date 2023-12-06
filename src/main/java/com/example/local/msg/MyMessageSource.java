package com.example.local.services;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

public class MyMessageSource implements MessageSource {
    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return "string ok";
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return "string ok";
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return "string ok";
    }
}
