package openpgp.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.didisoft.pgp.mail.PGPMailLib;

/**
 * Demonstrates sending PGP/MIME encrypted emails
 *
 * Copyright (c) DidiSoft 2015
 */
public class SendEncryptedMail {


/*
	public static void main(String[] a) {
		SendEncryptedMail send = new SendEncryptedMail();
		send.Send(SubjectType.votantiden.toString()+"co",";;1223654;;saad;;sarhani;;05/10/1996;;", "gl.vontant@gmail.com", "985632votant","gl.application.co@gmail.com", "privkeyvotant.asc", "pubkeyco.asc");
		send.Send(SubjectType.votantres.toString()+"co",";;mostapha;;", "gl.vontant@gmail.com", "985632votant","gl.application.co@gmail.com", "privkeyvotant.asc", "pubkeyde.asc");
		send.Send(SubjectType.votantiden.toString()+"de",";;1223654;;saad;;sarhani;;05/10/1996;;", "gl.vontant@gmail.com", "985632votant","gl.application.de@gmail.com", "privkeyvotant.asc", "pubkeyde.asc");
		send.Send(SubjectType.votantres.toString()+"de",";;mostapha;;", "gl.vontant@gmail.com", "985632votant","gl.application.de@gmail.com", "privkeyvotant.asc", "pubkeyde.asc");
	}	
	*/
	
	public  Boolean Send(String subjecttype,String text,String from,String password,String to,String privateKey,String publicKey) {
		 
	      String host = "smtp.gmail.com";
	      
	    
	      Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS    

	      // Get the default Session object.
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(from, password);
	                    }
	                });

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject(subjecttype);

	         // Now set the actual message
	         message.setText(text);
	         
	         // PGP encrypt here the message
	         PGPMailLib mailUtil = new PGPMailLib();
	         
	         String publicKeyFileName = "C:/Users/saad1/Desktop/project-chffrement/src/openpgp/DataFiles/"+publicKey;
	         String privateKeyFileName = "C:/Users/saad1/Desktop/project-chffrement/src/openpgp/DataFiles/"+privateKey;
	         String privateKeyPassword = "985632";
	        //had l password dyal les keys bach ykono sucrisé mat9isohomch
		      MimeMessage pgpMessage = mailUtil.signAndEncryptMessage(session, message, privateKeyFileName, privateKeyPassword, publicKeyFileName);

	         // Send message
	         Transport.send(pgpMessage);
	         System.out.println("Sent message successfully....");
	         return true;
	      }catch (com.didisoft.pgp.PGPException ex) {
		     ex.printStackTrace();	         
	      }catch (java.io.IOException ex) {
		     ex.printStackTrace();	         
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		return false;
	 }
}