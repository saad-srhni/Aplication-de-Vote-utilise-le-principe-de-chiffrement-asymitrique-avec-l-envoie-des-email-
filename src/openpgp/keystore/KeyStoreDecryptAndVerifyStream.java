package openpgp.keystore;
/*
 * Copyright 2010 DidiSoft Ltd. All Rights Reserved.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to verify a signed and encrypted stream
 * in the case when we store our partners keys in a KeyStore object.
 */
public class KeyStoreDecryptAndVerifyStream {
	public static void main(String[] args) throws Exception{
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library 
		PGPLib pgp = new PGPLib();
		
		// our private decryption key password
		String privateKeyPassword = "changeit";
	
		// obtain an encrypted stream
		InputStream encryptedStream = new FileInputStream("examples/DataFiles/encrypted.pgp");
		// specify the decrypted output stream
		OutputStream decryptedStream = new FileOutputStream("examples/DataFiles/OUTPUT.txt");
		
		boolean validSignature = pgp.decryptAndVerifyStream(encryptedStream, 
														keyStore, 
														privateKeyPassword, 
														decryptedStream);
		
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("Signature is invalid!");
		}
	}
}
