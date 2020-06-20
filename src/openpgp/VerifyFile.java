package openpgp;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates OpenPGP signed file verification.
 * 
 * Using the public key of the sender we can verify that he is really the source of
 * the signed file and extract the contents of the file at the same time.
 * 
 * This example assumes that the file signed.pgp was only signed with the private key of the sender.
 * (Note that this is different from sign and encrypt in one pass)
 */
public class VerifyFile {
	public static void main(String[] args) throws Exception{
		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		// verify
		boolean validSignature = pgp.verifyFile("examples/DataFiles/signed.pgp", 
		                                        "examples/DataFiles/public.key", 
		                                        "examples/DataFiles/OUTPUT.txt");		
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("!Signature is invalid!");
		}
	}
}
