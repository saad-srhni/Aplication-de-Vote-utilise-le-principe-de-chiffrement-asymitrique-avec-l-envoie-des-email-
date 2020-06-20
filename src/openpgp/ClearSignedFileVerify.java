package openpgp;

import com.didisoft.pgp.PGPLib;

/**
 * Demonstrates how to verify clear signed file. 
 */
public class ClearSignedFileVerify {
	public static void main(String[] args) throws Exception{	
		PGPLib pgp = new PGPLib();		
		
		boolean validSignature = pgp.verifyFile("examples/DataFiles/OUTPUT.sig.txt", 
		                                        "examples/DataFiles/public.key", 
		                                        "examples/DataFiles/OUTPUT.txt");
		if (validSignature) {
			System.out.println("File OUTPUT.sig.txt has a valid signature.");
		} else {
			System.out.println("File OUTPUT.sig.txt has an invalid signature.");
		}
	}
}