package openpgp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to decrypt an input stream.
 * The output and the key file are also passed as streams, this way  
 * we are not limited only to files, but can decrypt other sources -
 * for example database Blob fields. 
 */
public class DecryptStream {

	public static void main(String[] args) throws Exception{
		// create instance of the library
		PGPLib pgp = new PGPLib();

		// obtain an encrypted data stream
		InputStream encryptedStream = new FileInputStream("examples/DataFiles/encrypted.pgp");
		
        InputStream privateKeyStream = new FileInputStream("examples/DataFiles/private.key");
        String privateKeyPassword = "changeit";

        // specify the destination stream of the decrypted data
        OutputStream decryptedStream = new FileOutputStream("examples/DataFiles/OUTPUT.txt");
        
        pgp.decryptStream(encryptedStream, 
        				  privateKeyStream, 
        				  privateKeyPassword, 
        				  decryptedStream);
	}
}
