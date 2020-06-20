package openpgp;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to decrypt and verify a
 * one pass signed and encrypted OpenPGP archive.
 */
public class DecryptAndVerify {
	public static void main(String[] args) throws Exception{
		// create an instance of the library
		PGPLib pgp = new PGPLib();
	
		String privateKeyPassword = "changeit";
		@SuppressWarnings("deprecation")
		boolean validSignature = 
			pgp.decryptAndVerifyFile("/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/encrypted.pgp", 
									"/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/private.key", 
									privateKeyPassword, 
									"/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/public.key", 
									"/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/OUTPUT.txt");
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("Signature is invalid!");
		}
	}
}
