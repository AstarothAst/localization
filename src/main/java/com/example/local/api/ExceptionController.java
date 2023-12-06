package com.example.local.api;

import com.example.local.error.MyException;
import com.example.local.msg.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    private final MsgService msgService;

    @ExceptionHandler(MyException.class)
    public ResponseEntity<Object> ex(MyException e) {
        String message = msgService.get(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}