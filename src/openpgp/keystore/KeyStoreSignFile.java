package openpgp.keystore;
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates OpenPGP signing with no encryption.
 * 
 * We use our private key for creating the digital signature and our partners
 * will use our public key to verify it.  
 */
public class KeyStoreSignFile {
	public static void main(String[] args) throws Exception{		
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library 
		PGPLib pgp = new PGPLib();

		// The signing key is usually our private key
		String signUserId = "demo@didisoft.com";
		String signKeyPassword = "changeit";		
		
		// specify should the output be ASCII or binary
        boolean asciiArmor = false;
		pgp.signFile("examples/DataFiles/INPUT.txt",
					keyStore, 
					signUserId, 
					signKeyPassword, 
					"examples/DataFiles/signed.pgp", 
					asciiArmor);
	}
}
