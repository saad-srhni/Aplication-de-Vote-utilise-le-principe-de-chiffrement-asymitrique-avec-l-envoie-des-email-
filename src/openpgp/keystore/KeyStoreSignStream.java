package openpgp.keystore;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates OpenPGP signing a stream.
 * 
 * We use our private key for creating the digital signature and our partners
 * will use our public key to verify it.  
 */
public class KeyStoreSignStream {
	public static void main(String[] args) throws Exception{		
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library 
		PGPLib pgp = new PGPLib();

		// The signing key is usually our private key
		String signUserId = "demo@didisoft.com";
		String signKeyPassword = "changeit";		
		
		InputStream dataStream = new FileInputStream("examples/DataFiles/INPUT.txt");
		// this parameter is just a label that is associated with
		// the encrypted content in the OpenPGP archive
		String signedContentLabel = "INPUT.txt";
		
		// create the output stream		
		OutputStream signedStream = new FileOutputStream("examples/DataFiles/signed.pgp"); 
		
		// specify should the output be ASCII or binary
        boolean asciiArmor = false;
        
		pgp.signStream(dataStream,
					signedContentLabel,
					keyStore, 
					signUserId, 
					signKeyPassword, 
					signedStream, 
					asciiArmor);
	}
}
