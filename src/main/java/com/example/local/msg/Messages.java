package com.example.local.msg;

@LocalizedMessages
public class Messages {

    public static Message MSG_ONE = Message.builder()
            .en("message one %s, %d")
            .ru("сообщение один %s, %d")
            .build();

    public static Message MSG_TWO = Message.builder()
            .en("message two %s, %d")
            .ru("сообщение два %s, %d")
            .build();
}
