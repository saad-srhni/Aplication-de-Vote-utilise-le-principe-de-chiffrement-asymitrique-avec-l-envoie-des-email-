package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to verify a signed and encrypted file
 * in the case when we store our partners keys in a KeyStore object.
 */
public class KeystoreDecryptAndVerifyFile {
	public static void main(String[] args) throws Exception{
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library 
		PGPLib pgp = new PGPLib();
		
		// our private decryption key password
		String privateKeyPassword = "changeit";
		
		boolean validSignature = pgp.decryptAndVerifyFile("examples/DataFiles/encrypted.pgp", 
														keyStore, 
														privateKeyPassword, 
														"examples/DataFiles/OUTPUT.txt");
		
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("Signature is invalid!");
		}
	}
}
