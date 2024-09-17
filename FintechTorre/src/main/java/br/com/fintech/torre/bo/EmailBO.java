package br.com.fintech.torre.bo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.fintech.torre.exception.EmailException;


public class EmailBO {

	public void enviarEmail(String destinatario, String assunto, String mensagem) throws EmailException{
		
			return;
		
	}
		
	public void enviarEmail_OLD(String destinatario, String assunto, String mensagem) throws EmailException{
		final String username = "thalitazms@gmail.com";
		final String password = "zeid1705";

		Properties props = new Properties();  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
//		props.put("mail.smtp.socketFactory.port", "587");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
        
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message email = new MimeMessage(session);
			email.setFrom(new InternetAddress(username));
			email.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinatario));
			email.setSubject(assunto);
			email.setText(mensagem);

			Transport.send(email);

		} catch (MessagingException e) {
			System.out.println("Erro:" + e.toString());
			throw new EmailException("Erro ao enviar o e-mail");
		}
	}
}