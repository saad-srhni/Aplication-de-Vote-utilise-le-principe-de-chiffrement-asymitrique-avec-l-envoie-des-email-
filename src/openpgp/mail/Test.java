package openpgp.mail;

import java.io.IOException;
import java.io.InputStream;

import com.didisoft.pgp.CompressionAlgorithm;
import com.didisoft.pgp.CypherAlgorithm;
import com.didisoft.pgp.HashAlgorithm;
import com.didisoft.pgp.KeyAlgorithm;
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPException;
import com.didisoft.pgp.PGPLib;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.didisoft.pgp.mail.PGPMailLib;
import com.didisoft.pgp.mail.PGPMailUtils;

public class Test {

	public static void main(String[] args) throws PGPException, IOException {
		 // Recipient's email
		  String to = "saad1996kenitra@gmail.com";
	      // Sender email
	      String from = "gl.application.co@gmail.com";
	 
	      String password="985632co";
	      
	      Properties properties = System.getProperties();
	      properties.put("mail.smtp.starttls.enable", "true"); //TLS    
	      properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	     
	      properties.put("mail.smtp.user", from);
	      properties.put("mail.smtp.password", password);
	      properties.setProperty("mail.smtp.port", "587");
	      properties.setProperty("mail.smtp.auth", "true");
	      
	      
	 
	      // Get the default Session object.
	      Session session = Session.getInstance(properties,
	                new javax.mail.Authenticator() {
	    	  			@Override
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
		         message.setSubject("Bulltin vote");

		         // Now set the actual message
		         message.setText("hy test ");
		         
		         // PGP encrypt here the message
		         PGPMailLib mailUtil = new PGPMailLib();
		         
		         String publicKeyFileName = "/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/public.key";
		         String privateKeyFileName = "/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/private.key";
		         String privateKeyPassword = "changeit";
		         MimeMessage pgpMessage = mailUtil.signMessage(session, message, privateKeyFileName, privateKeyPassword);

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