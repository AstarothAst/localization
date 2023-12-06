package com.example.local.context;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ContextData {

    public static final String DEFAULT_LANG = "en";
    public static final String EN_LANG = DEFAULT_LANG;
    public static final String RU_LANG = "ru";

    public static ContextData empty() {
        return ContextData.builder().build();
    }

    private String lang;
}
