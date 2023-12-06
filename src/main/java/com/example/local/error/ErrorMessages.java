package com.example.local.error;

import com.example.local.msg.Message;

public class ErrorMessages {

    public static final Message SOME_ERROR = Message.builder()
            .ru("какая-то ашыпка: %s")
            .en("some error: %s")
            .build();
}
