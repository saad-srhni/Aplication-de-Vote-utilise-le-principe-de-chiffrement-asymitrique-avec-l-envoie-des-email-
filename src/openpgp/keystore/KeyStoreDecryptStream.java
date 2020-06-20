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
 * This example demonstrates how to decrypt an OpenPGP encrypted stream
 * with a private key stored in a KeyStore object.
 */
public class KeyStoreDecryptStream {
	public static void main(String[] args) throws Exception {
		// initialize the KeyStore instance
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library instance
		PGPLib pgp = new PGPLib();

		// obtain an encrypted stream
		InputStream encryptedStream = new FileInputStream("examples/DataFiles/encrypted.pgp");
		// specify the decrypted output stream
		OutputStream decryptedStream = new FileOutputStream("examples/DataFiles/OUTPUT.txt");
		
		String decryptionKeyPassword = "changeit";
		
		pgp.decryptStream(encryptedStream, 
						  keyStore, 
						  decryptionKeyPassword, 
						  decryptedStream);
	}
}
