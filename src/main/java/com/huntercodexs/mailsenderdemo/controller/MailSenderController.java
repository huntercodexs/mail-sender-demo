package com.huntercodexs.mailsenderdemo.controller;

import com.huntercodexs.mailsenderdemo.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import static com.huntercodexs.mailsenderdemo.service.Help4DevsFileHandlerService.fileToDataSource;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("${api.prefix}")
public class MailSenderController extends MailService {

	@Value("${mail-sender.from}")
	String from;

	@Value("${mail-sender.to}")
	String emailTo;

	@GetMapping(path = "/send")
	@ResponseBody
	public String send() {
		try {
			mailSenderDemo.sendMail(
					from,
					emailTo,
					"MAIL SENDER - Test",
					"Its only a test");
			return "DONE";
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			return "ERROR";
		}
	}

	@GetMapping(path = "/send-attach")
	@ResponseBody
	public String attach() throws IOException {
		try {
			mailSenderDemo.sendMailAttached(
					from,
					emailTo,
					"MAIL SENDER ATTACH - Test",
					"Its only a test",
					"attach.txt",
					fileToDataSource("./src/test/resources/", "attach.txt"));
			return "DONE";
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			return "ERROR";
		}
	}
}
