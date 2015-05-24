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
	@Value("${easy.url}")
	private String url;
	
	
	@Async
	public void sendMailNewPatient(String to, String username, String password, String nutricionist, Locale locale) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		try {
			helper = new MimeMessageHelper(message);

			// mail text
			String mailContent = readEmailTemplate();
			mailContent = replace(mailContent, "${email.title}", "email.title", locale, new String[0]);
			mailContent = replace(mailContent, "${email.subtitle}", "email.subtitle", locale, new String[0]);
			mailContent = replace(mailContent, "${email.username}", "email.username", locale, new String[]{username});
			mailContent = replace(mailContent, "${email.password}", "email.password", locale, new String[]{password});
			mailContent = replace(mailContent, "${email.url}", "email.url", locale, new String[]{url});
			mailContent = replace(mailContent, "${email.nutritionist}", "email.nutritionist", locale, new String[]{nutricionist});
			
			// message
			helper.setFrom(FROM);
			helper.setTo(to);
			helper.setSubject(messageSource.getMessage("email.subject", null, locale));
			helper.setText(mailContent, true);

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

	String replace(String text, String templateKey, String messageKey, Locale locale, String...param) {
		return text.replace(templateKey, messageSource.getMessage(messageKey, param, locale));
	}
	
}