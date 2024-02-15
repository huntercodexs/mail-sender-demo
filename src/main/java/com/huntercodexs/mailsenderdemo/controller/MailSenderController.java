package com.huntercodexs.mailsenderdemo.controller;

import com.huntercodexs.mailsenderdemo.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
			if (mailSenderDemo.sendMail(
					from,
					emailTo,
					"MAIL SENDER - Test",
					"Its only a test")) {

				return "DONE: E-mail sent successful";

			} else {
				return "ERROR: E-Mail not sent";
			}

		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			return "ERROR: Exception";
		}
	}

	@GetMapping(path = "/send-attach/{type}")
	@ResponseBody
	public String attach(@PathVariable String type) throws IOException {
		try {
			System.out.println("Attachment type: " + type);
			if (mailSenderDemo.sendMailAttached(
					from,
					emailTo,
					"MAIL SENDER ATTACH - Test",
					"Its only a test",
					"attach."+type,
					"./src/main/resources/attach."+type)) {

				return "DONE: E-mail sent successful";

			} else {
				return "ERROR: E-Mail Attach not sent";
			}

		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			return "ERROR: Exception";
		}
	}
}
