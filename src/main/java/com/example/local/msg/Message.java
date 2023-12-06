package com.example.local.msg;

import com.example.local.context.ContextData;
import com.example.local.context.UserContext;
import com.example.local.error.MyException;
import lombok.Builder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.example.local.context.ContextData.DEFAULT_LANG;
import static com.example.local.context.ContextData.EN_LANG;
import static com.example.local.context.ContextData.RU_LANG;

@Builder(toBuilder = true)
@Setter
@Slf4j
public class Message {

    private String en;
    private String ru;

    private UserContext userContext;
    private Object[] args;

    public static String get(MyException e) {
        Message message = e.getMessageObj();
        Object[] args = message.args;
        return message.get(args);
    }

    public Message args(Object... args) {
        return this.toBuilder()
                .args(args)
                .build();
    }

    public String getRu(Object... args) {
        return getByLang(RU_LANG, args);
    }

    public String getRu() {
        return getByLang(RU_LANG, args);
    }

    public String getEn(Object... args) {
        return getByLang(EN_LANG, args);
    }

    public String getEn() {
        return getByLang(EN_LANG, args);
    }

    public String getDefault(Object... args) {
        return getByLang(DEFAULT_LANG, args);
    }

    public String getDefault() {
        return getByLang(DEFAULT_LANG, args);
    }

    public String get(Object... args) {
        return getByLang(userContext.getLang(), args);
    }

    public String get() {
        return getByLang(userContext.getLang(), args);
    }

    private String getByLang(String lang, Object... args) {
        String text = switch (lang) {
            case ContextData.EN_LANG -> en;
            case ContextData.RU_LANG -> ru;
            default -> {
                log.warn("Incorrect lang: {}", lang);
                yield en;
            }
        };

        return Optional.ofNullable(args)
                .map(text::formatted)
                .orElse(text);
    }
}
