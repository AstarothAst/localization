package com.example.local.msg;

import com.example.local.context.UserContext;
import com.example.local.error.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.local.context.ContextData.DEFAULT_LANG;
import static com.example.local.context.ContextData.EN_LANG;
import static com.example.local.context.ContextData.RU_LANG;

@Service
@RequiredArgsConstructor
public class MsgService {

    private final UserContext userContext;

    public String getRu(Message message, Object... args) {
        return getByLang(message, RU_LANG, args);
    }

    public String getEn(Message message, Object... args) {
        return getByLang(message, EN_LANG, args);
    }

    public String getDefault(Message message, Object... args) {
        return getByLang(message, DEFAULT_LANG, args);
    }

    public String get(MyException e) {
        Message message = e.getMessageObj();
        Object[] args = e.getArgs();
        return get(message, args);
    }

    public String get(Message message, Object... args) {
        return getByLang(message, userContext.getLang(), args);
    }

    private String getByLang(Message message, String lang, Object... args){
        String text = message.getText(lang);
        return text.formatted(args);
    }

}
