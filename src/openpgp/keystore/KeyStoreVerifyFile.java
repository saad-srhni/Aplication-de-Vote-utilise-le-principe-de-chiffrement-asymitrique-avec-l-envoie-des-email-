package openpgp.keystore;
/*
 * Copyright 2010 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to verify a signed only file
 * in the case when we store our partners keys in a KeyStore object.
 */
public class KeyStoreVerifyFile {
	public static void main(String[] args) throws Exception{
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library 
		PGPLib pgp = new PGPLib();
		
		// verify
		boolean validSignature = pgp.verifyFile("examples/DataFiles/signed.pgp", 
												keyStore, 
												"examples/DataFiles/OUTPUT.txt");
		
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("!Signature is invalid!");
		}
	}
}
