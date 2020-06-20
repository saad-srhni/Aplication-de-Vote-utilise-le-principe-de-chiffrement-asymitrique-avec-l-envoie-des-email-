package openpgp.keystore;
/*
 * Copyright 2010 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This examples demonstrates how to sign and encrypt file in one pass 
 * using keys stored in a Key store. 
 */
public class KeystoreSignAndEncryptFile {
	public static void main(String[] args) throws Exception{
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");		

		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		// is output ASCII or binary
        boolean asciiArmor = true; 
        // should integrity check information be appended
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = true; 
		
		// The signing key is usually our private key
		String signUserId = "demo@didisoft.com";
		String signKeyPassword = "changeit";		
		// the User Id of the recipient, this  
		// example assumes her public key is
		// already imported in the KeyStore file
		String encUserId = "demo2@didisoft.com";
		
		pgp.signAndEncryptFile("examples/DataFiles/INPUT.txt",
				              	keyStore,
				              	signUserId,
				              	signKeyPassword,
				              	encUserId,
				              	"examples/DataFiles/encrypted.pgp",                                  
				              	asciiArmor, 
				              	withIntegrityCheck);
	}
}
