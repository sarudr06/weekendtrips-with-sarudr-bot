package com.sarudr.reportservice.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sarudr06@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Mail Send...");

	}

//    public void sendSimpleEmailAttachmnet(String toEmail,
//            String subject,
//            String body
//) throws MessagingException {
//   	 MimeMessage mimeMessage = mailSender.createMimeMessage();
//
//        MimeMessageHelper mimeMessageHelper
//                = new MimeMessageHelper(mimeMessage, true);
//
//        mimeMessageHelper.setFrom("spring.email.from@gmail.com");
//        mimeMessageHelper.setTo(toEmail);
//        mimeMessageHelper.setText(body);
//        mimeMessageHelper.setSubject(subject);
//
//        FileSystemResource fileSystem
//                = new FileSystemResource(new File("http://localhost"));
//
//        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
//                fileSystem);
//
//        mailSender.send(mimeMessage);
//   	
//   	}

}
