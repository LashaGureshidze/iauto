package ge.iauto.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MessageSendService {
	public static void sendMessage(String to,String code){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.user","freeiauto@gmail.com");
		props.put("mail.smtp.password", "otherwise");
		Session session = Session.getDefaultInstance(props);
		try {
			 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("freeiauto@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("IAUTO - ვერიფიკაცია");
			
			message.setText("თქვენი ვერიფიკაციის კოდია:  " + code);
 
			Transport transport = session.getTransport("smtps");
			transport.connect("smtp.gmail.com", 465, "freeiauto@gmail.com","otherwise");
			transport.sendMessage(message, message.getAllRecipients());
			
			transport.close();
 
			System.out.println("message sent!");
			
 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
