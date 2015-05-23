package com.easynutrition.business.mail;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BusinessMailSender {
	private static final Logger LOGGER = LoggerFactory.getLogger(BusinessMailSender.class);
	private static final String FROM = "easynutrition.info@gmail.com";
    @Autowired
    private MessageSource messageSource;
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Value("classpath:email/template-email.html")
	private Resource template;
	
	
	@Async
	public void sendMail(String to) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		try {
			helper = new MimeMessageHelper(message);

			// subject
			String text = readEmailTemplate()
				.replace("${user}", "TODO1")
				.replace("${password}", "TODO2")
				.replace("${url}", "TODO3")
				.replace("${nutritionist}", "TODO4");
			
			// message
			helper.setFrom(FROM);
			helper.setTo(to);
			helper.setSubject(messageSource.getMessage("email.subject", null, Locale.ENGLISH));
			helper.setText(text, true);

			// send
			mailSender.send(message);
		} catch (Exception e) {
			LOGGER.error("Error while reading email template", e);
		}
	}
	
	String readEmailTemplate() throws Exception {
		byte[] encoded = Files.readAllBytes(Paths.get(template.getURI()));
		return new String(encoded);
	}

}