package openpgp.keystore;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to verify a signed only stream
 * in the case when we store our partners keys in a KeyStore object.
 */
public class KeyStoreVerifyStream {
	public static void main(String[] args) throws Exception{
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library 
		PGPLib pgp = new PGPLib();
	
		// obtain the signed stream
		InputStream signedStream = new FileInputStream("examples/DataFiles/signed.pgp");
		// specify the decrypted output stream
		OutputStream decryptedStream = new FileOutputStream("examples/DataFiles/OUTPUT.txt");
		
		boolean validSignature = pgp.verifyStream(signedStream, 
												keyStore, 
												decryptedStream);
		
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("!Signature is invalid!");
		}
	}
}
