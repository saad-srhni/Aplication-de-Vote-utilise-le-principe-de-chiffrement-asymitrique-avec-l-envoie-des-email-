package openpgp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to decrypt and verify 
 * one pass OpenPGP signed and encrypted message 
 * supplied as stream. 
 */
public class DecryptAndVerifyStream {
	public static void main(String[] args) throws Exception{
		// create an instance of the library
		PGPLib pgp = new PGPLib();

		// obtain a signed and encrypted data stream
		InputStream encryptedStream = new FileInputStream("DataFiles/encrypted.pgp");
		
        InputStream privateKeyStream = new FileInputStream("DataFiles/private.key");
        String privateKeyPassword = "changeit";

        InputStream senderPublicKeyStream = new FileInputStream("DataFiles/public.key");
        
        // specify the destination stream of the decrypted data
        OutputStream decryptedStream = new FileOutputStream("DataFiles/OUTPUT.txt");
		
		boolean validSignature = 
			pgp.decryptAndVerifyStream(encryptedStream, 
										privateKeyStream, privateKeyPassword, 
										senderPublicKeyStream, 
										decryptedStream);
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("Signature is invalid!");
		}
	}
}
