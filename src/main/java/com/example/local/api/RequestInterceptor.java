package com.example.local.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Здесь можно выполнить любую предварительную обработку запроса
        System.out.println("thread: " + Thread.currentThread().threadId());
        System.out.println("Перехватчик перехватил запрос до контроллера");
        return true; // Если возвращается false, выполнение контроллера прерывается
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // Здесь можно выполнить дополнительную обработку после вызова метода контроллера
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // Здесь можно выполнить обработку после завершения запроса
    }
}