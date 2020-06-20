package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to encrypt file using public key located in KeyStore.
 */
public class KeystoreEncryptFile {
	public static void main(String[] args) throws Exception{
		
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// create an instance of the library
		PGPLib pgp = new PGPLib();	
		
		String recipientUserId = "demo@didisoft.com";
		
		// is output ASCII or binary
        boolean asciiArmor = true; 
        // should integrity check information be added
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = true; 
		
		pgp.encryptFile("examples/DataFiles/INPUT.txt", 
						keyStore, 
						recipientUserId, 
						"examples/DataFiles/encrypted.pgp", 
						asciiArmor, 
						withIntegrityCheck);
	}	
}
