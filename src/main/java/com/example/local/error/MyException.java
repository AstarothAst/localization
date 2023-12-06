package com.example.local.error;

import com.example.local.msg.Message;

public class MyException extends RuntimeException{

    private final Message message;
    private final Object[] args;

    public MyException(Message message, Object ...args) {
        this.message = message;
        this.args = args;
    }

    public Message getMessageObj(){
        return message;
    }

    public Object[] getArgs() {
        return args;
    }
}
