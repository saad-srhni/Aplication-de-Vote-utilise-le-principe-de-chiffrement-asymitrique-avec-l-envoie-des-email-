package openpgp.mail;

import java.io.File;
import java.io.IOException;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;

import com.sun.mail.imap.IMAPStore;

public class ReceiveEncryptedMail {
	

	public ReceiveEncryptedMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void receiveEmail(String pop3Host, String user, String password, String saveDirectory, int nbrmessage)
			throws IOException {

		try {
			Properties properties = new Properties();
			// properties.put("mail.imaps.host", pop3Host);
			// properties.put("mail.imaps.port", "995");
			properties.put("mail.store.protocol", "imaps");

			properties.setProperty("charset", "utf-8");
			Session emailSession = Session.getDefaultInstance(properties);

			// 2) create the POP3 store object and connect with the pop server
			IMAPStore emailStore = (IMAPStore) emailSession.getStore("imaps");
			emailStore.connect("imap.gmail.com", user, password);

			// 3) create the folder object and open it
			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// 4) retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println(messages.length);
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				// --------------------------------------------------------
				String subject = message.getSubject();
				if (nbrmessage > 0
						&& (message.getSubject().compareTo(SubjectType.votantiden.toString() + "de") == 0
								|| message.getSubject().compareTo(SubjectType.votantres.toString() + "de") == 0
								|| message.getSubject().compareTo(SubjectType.votantiden.toString() + "co") == 0
						|| message.getSubject().compareTo(SubjectType.votantres.toString() + "co") == 0)) {
					System.out.println(message.getSubject() + "-------------------- " + nbrmessage);
					nbrmessage = nbrmessage - 1;
					String contentType = message.getContentType();
					// store attachment file name, separated by comma
					String attachFiles = "";

					if (contentType.contains("multipart")) {
						// content may contain attachments
						Multipart multiPart = (Multipart) message.getContent();
						int numberOfParts = multiPart.getCount();
						System.out.println(numberOfParts);
						MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(1);
						if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
							// this part is attachment
							String fileName = part.getFileName();
							attachFiles += fileName + ", ";
							part.saveFile(saveDirectory + File.separator + subject);
							System.out.println(("aaaaaaaaaaddddddddddddddddd"));
						} else {
						}

						if (attachFiles.length() > 1) {
							attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
						}
					} else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
						Object content = message.getContent();
						if (content != null) {
						}
					}
				}
				// --------------------------------------------------------------------
			}

			// 5) close the store and folder objects
			emailFolder.close(false);
			emailStore.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	/*
	 * public static void main(String[] a) throws IOException { ReceiveEncryptedMail
	 * receiveDemo = new ReceiveEncryptedMail();
	 * receiveDemo.receiveEmail("imap.gmail.com", "gl.application.co@gmail.com",
	 * "985632co", "/home/saad/eclipse-workspace/ApplicationVote/msgstore/co", 2);
	 * 
	 * }
	 */

}