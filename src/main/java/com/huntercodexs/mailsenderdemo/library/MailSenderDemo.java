package com.huntercodexs.mailsenderdemo.library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@Service
public class MailSenderDemo {

    @Autowired
    private final JavaMailSender javaMailSender;

    public MailSenderDemo(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean sendMail(String from, String to, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            javaMailSender.send(message);
            return true;
        } catch (RuntimeException re) {
            log.error("SEND MAIL ERROR");
            log.error(re.getMessage());
            return false;
        }
    }

    public boolean sendMailAttached(
            String from,
            String to,
            String subject,
            String content,
            String filename,
            String attachment
    ) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.setFrom(from);

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource fileToAttach = new FileSystemResource(new File(attachment));
            helper.addAttachment(filename, fileToAttach);

            javaMailSender.send(message);
            return true;
        } catch (MessagingException me) {
            log.error("SEND MAIL ATTACH ERROR");
            log.error(me.getMessage());
            return false;
        }
    }

}
