package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;

/**
 * This example shows how to import a key ring file into a KeyStore.
 * 
 * The key ring file may contain public, private or 
 * both type of keys if it is in ASCII armored format
 */
public class ImportKeyPair {
	public static void main(String[] args) throws Exception {
		// initialize the KeyStore. The key store file may not exist
		// and subsequent operations will create it
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// imports key ring file. The file may contain public, private or 
		// both type of keys if it is in ASCII armored format
		keyStore.importKeyRing("examples/DataFiles/private.key");
	}
}
