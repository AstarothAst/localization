package com.example.local.services;

import com.example.local.error.ErrorMessages;
import com.example.local.error.MyException;
import com.example.local.msg.Message;
import com.example.local.msg.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyService {

    public String doSomething() {
        log.info(Messages.MSG_TWO.getRu("рус", 2));
        log.info(Messages.MSG_TWO.getEn(), "eng", 2);
        log.info(Messages.MSG_TWO.getDefault("def", 2));

        // возврат зависит от заголовка Accept-Language
        return Messages.MSG_ONE.get("[рус/eng]", 100);
    }

    public String doSomethingError() {
        if (true) {
            Message message = ErrorMessages.SOME_ERROR.args("Oooops!", 100500);
            log.error(message.getEn());
            throw new MyException(message);
        }
        return "";
    }
}
