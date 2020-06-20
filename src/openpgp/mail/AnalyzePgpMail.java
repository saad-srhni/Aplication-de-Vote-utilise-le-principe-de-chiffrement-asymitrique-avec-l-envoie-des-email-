package openpgp.mail;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.didisoft.pgp.KeyPairInformation;
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPException;
import com.didisoft.pgp.SignatureCheckResult;
import com.didisoft.pgp.inspect.SignatureItem;
import com.didisoft.pgp.mail.PGPMailInspectLib;
import com.didisoft.pgp.mail.PGPMailLib;

/**
 * An example that illustrates how to analyze details for an incoming PGP email 
 */
public class AnalyzePgpMail {

	public static void analyze(MimeMessage message) throws MessagingException, IOException, PGPException {		
		PGPMailLib mailLib = new PGPMailLib();
		PGPMailInspectLib inspectLib = new PGPMailInspectLib();
		
		// PGP encrypted email
		if (mailLib.isOpenPGPEncrypted((Message)message)) {
			long[] encryptionKeyIds = inspectLib.listEncryptionKeyIds(message);
			
			// search do we have any of the encryption keys
			KeyStore ks = new KeyStore(); // probably loaded from a file or database
			for (int i = 0; i < encryptionKeyIds.length; i++) {
				KeyPairInformation key = ks.getKey(encryptionKeyIds[i]);
				// if we have the private key
				if (key != null && key.hasPrivateKey())
				{
					// we can use this private key to decrypt the message
					String keyPassword = "...";
					MimeMessage originalMessage = mailLib.decryptMessage(message, ks, keyPassword);
				}
			}								
		} 
		// PGP signed email
		else if (mailLib.isOpenPGPSigned((Message)message)) {
			
			SignatureItem[] signatures = inspectLib.listSignatures(message);
			
			KeyStore ks = new KeyStore(); // probably loaded from a file or database
			// search do we have any of the signing keys
			for (int i = 0; i < signatures.length; i++) {
				KeyPairInformation key = ks.getKey(signatures[i].getKeyId());
				// if we have this key
				if (key != null)
				{
					SignatureCheckResult signatureCheck = mailLib.verifyMessage(message, ks);
					if (signatureCheck.equals(SignatureCheckResult.SignatureVerified))
					{
						System.out.println("Signature Verified OK");
					}
				}				
			}
			
		}
	}

}
