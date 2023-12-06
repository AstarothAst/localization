package com.example.local.context;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.local.context.ContextData.DEFAULT_LANG;
import static com.example.local.context.ContextData.RU_LANG;

@Service
public class UserContext {

    private final List<String> supportedLanguages = List.of(DEFAULT_LANG, RU_LANG);

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
                .filter(supportedLanguages::contains)
                .map(String::toLowerCase)
                .orElse(DEFAULT_LANG);
        context.get().setLang(toStore);
    }
}
