package openpgp;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates OpenPGP signing with no encryption.
 * 
 * We use our private key for creating the digital signature and our partners
 * will use our public key to verify it.  
 */
public class SignFile {
	public static void main(String[] args) throws Exception{
		// initialize the library 
		PGPLib pgp = new PGPLib();
		
		// specify should the output be ASCII or binary
        boolean asciiArmor = false;
		pgp.signFile("examples/DataFiles/INPUT.txt", 
					"examples/DataFiles/private.key", 
					"changeit", 
					"examples/DataFiles/signed.pgp", 
					asciiArmor);
	}
}
