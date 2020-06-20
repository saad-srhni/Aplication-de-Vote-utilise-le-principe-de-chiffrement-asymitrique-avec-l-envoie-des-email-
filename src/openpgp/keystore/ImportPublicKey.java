package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;

/**
 * This example demonstrates how to import an OpenPGP public key into a KeyStore file
 */
public class ImportPublicKey {
	public static void main(String[] args) throws Exception{
		// initialize the KeyStore. The key store file may not exist
		// and subsequent operations will create it		
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// import the key
		keyStore.importPublicKey("examples/DataFiles/public.key");
	}
}
