package vn.iostart.ultils;

import java.util.Properties;
import java.util.Random;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import vn.iostart.model.Users;

public class Email {
	public String getRandom() {
		Random rnd =new Random();
		int number= rnd.nextInt(999999);
		return String.format("%06d", number);
		}
		//send email to the user email
		public boolean sendEmail (Users user) {
		boolean test = false;
		String toEmail= user.getEmail(); 
		String fromEmail= "vophuhao2004@gmail.com"; 
		String password = "phuhao123";
		try {
			// your host email smup server details
			Properties pr= configEmail(new Properties());
			//get session to authenticate the host email address and password 
			Session session= Session.getInstance(pr, new Authenticator() { 
				@Override
			
			protected PasswordAuthentication getPasswordAuthentication() 
			{ 
				return new PasswordAuthentication (fromEmail, password);
			}
			});
			//set email message details
			Message mess =new MimeMessage(session);
			mess.setHeader("Content-Type", "text/plain; charset=UTF-8");
			//set from email address
			mess.setFrom(new InternetAddress (fromEmail));
			
			mess.setRecipient (Message. RecipientType. TO, new InternetAddress(toEmail));
			//set email subject 
			mess.setSubject("Yours Password");
			//set message text 
			mess.setText("Password: "+ user.getPassWord());
			//send the message 
			Transport.send(mess);
			test=true;
		}
		catch(Exception e)
		{
			e.printStackTrace()
;		}
		return test;
		}
		

		private Properties configEmail(Properties pr) {
			pr.setProperty("mail.smtp.host", "smtp.gmail.com");
			pr.setProperty("mail.smtp.port", "587");
			pr.setProperty("mail.smtp.auth", "true");
			pr.setProperty("mail.smtp.starttls.enable", "true"); pr.put("mail.smtp.socketFactory.port", "587");
			pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			return pr;
			}
		
}
