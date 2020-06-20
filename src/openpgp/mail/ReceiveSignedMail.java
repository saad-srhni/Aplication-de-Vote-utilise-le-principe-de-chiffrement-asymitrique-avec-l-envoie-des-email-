package openpgp.mail;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import com.didisoft.pgp.mail.PGPMailLib;
import com.sun.mail.pop3.POP3Store;

public class ReceiveSignedMail {
	private boolean textIsHtml = false;
	
	private String getText(Part p) throws MessagingException, IOException {
		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			textIsHtml = p.isMimeType("text/html");
			return s;
		}

		if (p.isMimeType("multipart/alternative")) {
			// prefer html text over plain text
			Multipart mp = (Multipart) p.getContent();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) {
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) {
					if (text == null)
						text = getText(bp);
					continue;
				} else if (bp.isMimeType("text/html")) {
					String s = getText(bp);
					if (s != null)
						return s;
				} else {
					return getText(bp);
				}
			}
			return text;
		} else if (p.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getText(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}

		return null;
	}	
	
	public void receiveEmail(String pop3Host, 
									String user, 
									String password) {

	 try {
	   Properties properties = new Properties();  
	   properties.put("mail.pop3.host", pop3Host);  
	   Session emailSession = Session.getDefaultInstance(properties);  
	     
	   //2) create the POP3 store object and connect with the pop server  
	   POP3Store emailStore = (POP3Store) emailSession.getStore("pop3");  
	   emailStore.connect(user, password);  
	  
	   //3) create the folder object and open it  
	   Folder emailFolder = emailStore.getFolder("INBOX");  
	   emailFolder.open(Folder.READ_ONLY);  
	  
	   //4) retrieve the messages from the folder in an array and print it  
	   Message[] messages = emailFolder.getMessages();  
	   for (int i = 0; i < messages.length; i++) {  
	    Message message = messages[i];  
	    System.out.println("---------------------------------");  
	    System.out.println("Email Number " + (i + 1));  
	    System.out.println("Subject: " + message.getSubject());  
	    System.out.println("From: " + message.getFrom()[0]);  
	    System.out.println("Text: h" + message.getContent().toString());
	    
	    PGPMailLib mailUtil = new PGPMailLib();
	    if (mailUtil.isOpenPGPSigned(message)) {	    	

	    	try {
	    		boolean signatureCheck = mailUtil.verify((MimeMessage)message, "examples/DataFiles/public.key");
    		
	    		System.out.println("Signature verification : " + signatureCheck);
	    	} catch (Exception e) {
	    		System.out.println(e.getMessage());
	    	}    		

	    	// pgp signed only message
	    	MimeBodyPart decrypted = mailUtil.getSignedContent((MimeMessage)message);
	        String content = getText(decrypted);
	        System.out.println(content);
	    } else {
	    	System.out.println(message.getContentType());
	    }
	   }  
	  
	   //5) close the store and folder objects  
	   emailFolder.close(false);  
	   emailStore.close();  
	  
	  } catch (NoSuchProviderException e) {e.printStackTrace();}   
	  catch (MessagingException e) {e.printStackTrace();}  
	  catch (IOException e) {e.printStackTrace();}  
	 }
	
	/*public static void main(String[] a) {
		ReceiveEncryptedMail receiveDemo = new ReceiveEncryptedMail();
		try {
//			receiveDemo.receiveEmail("mail.mywebsite.com", "me@mywebsite.com", "my POP3 password", null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
