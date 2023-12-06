package com.example.local.error;

import com.example.local.msg.LocalizedMessages;
import com.example.local.msg.Message;

@LocalizedMessages
public class ErrorMessages {

    public static Message SOME_ERROR = Message.builder()
            .ru("какая-то ашыпка: %s")
            .en("some error: %s")
            .build();
}
