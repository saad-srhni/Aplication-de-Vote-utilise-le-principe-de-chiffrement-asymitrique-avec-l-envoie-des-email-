package openpgp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to sign (with our private key)
 * and encrypt (with the recipient) public key in one pass.
 * 
 * The input file, the keys and the output are accepted as streams,
 * this way this method is not limited to file system data, 
 * but can work with other types of media - for example the streams can read, write to a database Blob fields.  
 */
public class SignAndEncryptStream {
	public static void main(String[] args) throws Exception{
		// initialize the library 
		PGPLib pgp = new PGPLib();

		// is output ASCII or binary
		boolean asciiOutput = true;
		// should integrity check information be appended
		boolean withIntegrityCheck = true;
		
		// recipient public key as stream
		InputStream recipientPublicKeyStream = new FileInputStream("examples/DataFiles/public.key");
		
		// private signing key as stream
		InputStream privateKeyStream = new FileInputStream("examples/DataFiles/private.key");
		String privateKeyPassword = "changeit";

		// input stream to be encrypted
		InputStream inputStream = new FileInputStream("examples/DataFiles/INPUT.txt");
		// encrypted output destination
		OutputStream encryptedOutStream = new FileOutputStream("examples/DataFiles/encrypted.pgp");
				
		// Here "INPUT.txt" is just a string to be written in the message OpenPGP packet
		// The message packet is a mandatory component of the pgp file internals and holds:
		// file name string, timestamp, and the actual data bytes
		pgp.signAndEncryptStream(inputStream, 
								"INPUT.txt", 
								privateKeyStream,
								privateKeyPassword,
								recipientPublicKeyStream, 
								encryptedOutStream, 
								asciiOutput, 
								withIntegrityCheck);
	}
}
