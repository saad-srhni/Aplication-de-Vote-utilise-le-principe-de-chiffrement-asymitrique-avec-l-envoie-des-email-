package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;

/**
 * This example demonstrates how to import an existing OpenPGP file
 * into a KeyStore file. 
 * 
 * Using a keyStore gives us additional layer of security.
 */
public class ImportPrivateKey {
	public static void main(String[] args) throws Exception {
		// initialize the KeyStore. The key store file may not exist
		// and subsequent operations will create it
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// import the key
		keyStore.importPrivateKey("examples/DataFiles/private.key", "changeit");
	}
}
