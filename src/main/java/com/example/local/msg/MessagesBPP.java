package com.example.local.msg;

import com.example.local.context.UserContext;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static java.util.Objects.nonNull;

@Component
@Slf4j
public class MessagesBPP implements BeanPostProcessor {

    private final UserContext userContext;

    @Lazy
    public MessagesBPP(UserContext userContext) {
        this.userContext = userContext;
    }

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (nonNull(bean.getClass().getAnnotation(LocalizedMessages.class))) {
            return injectUserContextToAllMessages(bean);
        } else {
            return bean;
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private Object injectUserContextToAllMessages(Object bean) {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers()))
                .filter(field -> field.getType().equals(Message.class))
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        Message updateMessage = ((Message) field.get(null)).toBuilder()
                                .userContext(userContext)
                                .build();
                        ReflectionUtils.setField(field, null, updateMessage);
                    } catch (IllegalAccessException e) {
                        log.error("Error inject userContext to message");
                        throw new RuntimeException(e);
                    }
                });
        return null;
    }
}

