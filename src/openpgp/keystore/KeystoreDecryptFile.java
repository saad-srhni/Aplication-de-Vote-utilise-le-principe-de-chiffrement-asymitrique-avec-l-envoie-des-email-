package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates how to decrypt an OpenPGP encrypted file 
 * with a private key stored in a KeyStore object.
 */
public class KeystoreDecryptFile {
	public static void main(String[] args) throws Exception {
		// initialize the KeyStore instance
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// initialize the library instance
		PGPLib pgp = new PGPLib();
		
		// The decrypt method returns the original name of the file
		// that was encrypted. We can use it afterwards,
		// to rename OUTPUT.txt to it for example.
		String originalFileName = pgp.decryptFile("examples/DataFiles/encrypted.pgp", 
												keyStore, 
												"changeit", 
												"examples/DataFiles/OUTPUT.txt");
	}
}
