package openpgp.keystore;
/*
 * Copyright 2010 DidiSoft Ltd. All Rights Reserved.
 */

import com.didisoft.pgp.KeyStore;

/**
 * This example demonstrates how to export a key pair (both public and private key) from a KeyStore file.
 * 
 * The method refers the key pair by User Id, 
 * but also an overloaded version exists that accepts Key Id.
 */
public class ExportKeyPair {
	public static void main(String[] args) throws Exception{
		// initialize the key store
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// export
		keyStore.exportKeyRing("examples/DataFiles/keypair.asc", "demo@didisoft.com");		
	}
}

