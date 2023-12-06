package com.example.local.api;

import com.example.local.services.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class Api {

    private final MyService service;

    @GetMapping("/do")
    public String doSomething(){
        return service.doSomething();
    }

    @GetMapping("/do-error")
    public String doSomethingError(){
        return service.doSomethingError();
    }
}
