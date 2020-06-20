package openpgp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to encrypt an input stream.
 * 
 * The output and the key file are also passed as streams, this way  
 * we are not limited only to files, but can encrypt other sources -
 * for example database Blob fields. 
 */
public class EncryptStream {
	public static void main(String[] args) throws Exception{
		
		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		// is output ASCII or binary
        boolean asciiArmor = true; 
        // should integrity check information be added
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = true; 
        
        // obtain the streams 
        InputStream inStream = new FileInputStream("examples/DataFiles/INPUT.txt");
        InputStream keyStream = new FileInputStream("examples/DataFiles/public.key");
        OutputStream outStream = new FileOutputStream("examples/DataFiles/encrypted.pgp");
        
        // Here "INPUT.txt" is just a string to be written in the message OpenPGP packet
        // The message packet is a mandatory component of the pgp file internals and holds:
        // file name string, timestamp, and the actual data bytes
        pgp.encryptStream(inStream, "INPUT.txt", keyStream, outStream, asciiArmor, withIntegrityCheck);
	}
}
