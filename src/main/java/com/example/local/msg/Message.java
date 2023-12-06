package com.example.local.msg;

import com.example.local.context.ContextData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Builder
@Setter
@Slf4j
public class Message {

    private String en;
    private String ru;

    public String getText(String lang) {
        return switch (lang) {
            case ContextData.EN_LANG -> en;
            case ContextData.RU_LANG -> ru;
            default -> {
                log.warn("Incorrect lang: {}", lang);
                yield en;
            }
        };
    }
}
