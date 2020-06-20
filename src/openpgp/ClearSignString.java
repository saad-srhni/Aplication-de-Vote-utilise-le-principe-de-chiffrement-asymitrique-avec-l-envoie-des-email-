package openpgp;

import com.didisoft.pgp.HashAlgorithm;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to clear sign a string message. 
 */
public class ClearSignString {
	public static void main(String[] args) throws Exception{
		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		String message = "The quick brown fox jumps.";
		
		// clear sign
		String privateKeyPassword = "changeit";
		String clearSignedMessage = 
			pgp.clearSignString(message, 
			                    "examples/DataFiles/private.key", 
			                    privateKeyPassword, 
			                    HashAlgorithm.SHA256);
	}
}
