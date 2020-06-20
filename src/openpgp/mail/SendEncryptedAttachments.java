package openpgp.mail;

import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.didisoft.pgp.mail.PGPMailLib;
import java.io.File;

/**
 * Demonstrates sending PGP/MIME encrypted emails with Attanchments
 *
 * Copyright (c) DidiSoft 2015
 */
public class SendEncryptedAttachments {
		
	public static void main(String[] args) {
		  // Recipient's email
	      String to = "support@ereport.bg";
	      // Sender email
	      String from = "sales@nciphers.com";

	      // SMTP host
	      String host = "cobra.superhosting.bg";
	      
	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", "25");
	      
	      properties.setProperty("mail.user", from);
	      properties.setProperty("mail.password", "Silvercolors123");	      

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	        	 message.setSubject("PGP email with attachments");
	        	 message.setSentDate(new java.util.Date());

	             BodyPart messageBodyPart = new MimeBodyPart();
	             messageBodyPart.setText("Hello World as message text!");
	             MimeMultipart _multipart = new MimeMultipart();
	             _multipart.addBodyPart(messageBodyPart);

	             // setup attachment
                 java.io.File file = new File("c:\\TEMP\\didisoft.jpg");
                 MimeBodyPart attachBodyPart = new MimeBodyPart();
                 DataSource source = new FileDataSource(file.getAbsolutePath());
                 attachBodyPart.setDataHandler(new DataHandler(source));
                 String name = file.getName();
                 attachBodyPart.setFileName(name);
	             // for each attachment do addBodyPart 
                 _multipart.addBodyPart(attachBodyPart);

	             // Put parts in message
                 message.setContent(_multipart);

	             MimeMessage pgpMessage = null;
	             PGPMailLib mailUtil = new PGPMailLib();
	             String publicKeyFileName = "examples/DataFiles/public.key";
	             pgpMessage = mailUtil.encryptMessage(session, message, publicKeyFileName);

		
	         // Send message
	         Transport.send(pgpMessage);
	         System.out.println("Sent message successfully....");
	      }catch (com.didisoft.pgp.PGPException ex) {
		     ex.printStackTrace();	         
	      }catch (java.io.IOException ex) {
		     ex.printStackTrace();	         
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	 }
}
