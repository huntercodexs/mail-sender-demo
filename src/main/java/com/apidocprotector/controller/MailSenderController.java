package com.apidocprotector.controller;

import com.apidocprotector.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*")
public class MailSenderController extends MailService {

	@Value("${mail-sender.from}")
	String from;

	@Value("${mail-sender.to}")
	String emailTo;

	@PostMapping(path = "/send")
	@ResponseBody
	public String send() {
		try {
			mailSenderDemo.sendMail(from, emailTo, "MAIL SENDER - Test", "Its only a test");
			return "OK";
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			return "ERROR";
		}
	}
}
