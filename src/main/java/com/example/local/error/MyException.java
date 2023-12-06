package com.example.local.error;

import com.example.local.msg.Message;

public class MyException extends RuntimeException{

    private final Message message;

    public MyException(Message message) {
        this.message = message;
    }

    public Message getMessageObj(){
        return message;
    }
}
