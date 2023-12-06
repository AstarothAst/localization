package com.example.local.context;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserContextImpl implements UserContext {

    private static final String DEFAULT_LANG = "en";
    private static final String RU_LANG = "ru";

    private final List<String> supportedLangs = List.of(DEFAULT_LANG, RU_LANG);

    private final InheritableThreadLocal<ContextData> context = new InheritableThreadLocal<>();

    @PostConstruct
    private void init(){
        context.set(ContextData.empty());
    }

    public String getLang() {
        return Optional.ofNullable(context.get().getLang()).orElse(DEFAULT_LANG);
    }

    public void setLang(String lang){
        String toStore = Optional.ofNullable(lang)
                .filter(supportedLangs::contains)
                .map(String::toLowerCase)
                .orElse(DEFAULT_LANG);
        context.get().setLang(toStore);
    }
}
