package com.huntercodexs.mailsenderdemo.service;

import com.huntercodexs.mailsenderdemo.library.MailSenderDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public abstract class MailService {
    @Autowired
    protected MailSenderDemo mailSenderDemo;
}
