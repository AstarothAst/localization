package com.example.local.services;

import com.example.local.error.ErrorMessages;
import com.example.local.error.MyException;
import com.example.local.msg.Messages;
import com.example.local.msg.MsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyService {

    private final MsgService msgService;

    public String doSomething() {
        log.info(msgService.getRu(Messages.MSG_TWO, "two", 2));
        log.info(msgService.getEn(Messages.MSG_TWO, "two", 2));
        log.info(msgService.getDefault(Messages.MSG_TWO, "two", 2));

        // возврат зависит от заголовка Accept-Language
        return msgService.get(Messages.MSG_ONE, "one", 1);
    }

    public String doSomethingError() {
        if(true){
            throw new MyException(ErrorMessages.SOME_ERROR, "Oooops!");
        }
        return "";
    }
}
