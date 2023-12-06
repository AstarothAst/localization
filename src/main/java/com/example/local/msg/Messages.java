package com.example.local.msg;

public class Messages {

    public static final Message MSG_ONE = Message.builder()
            .en("message one %s, %d")
            .ru("сообщение один %s, %d")
            .build();

    public static final Message MSG_TWO = Message.builder()
            .en("message two %s, %d")
            .ru("сообщение два %s, %d")
            .build();
}
