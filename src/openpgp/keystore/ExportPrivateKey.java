package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import com.didisoft.pgp.KeyStore;

/**
 * This example demonstrates how to export a private key only from a KeyStore file.
 * 
 * The method refers the private key by user Id, 
 * but also an overloaded version exists that accepts Key Id.
 */
public class ExportPrivateKey {
	public static void main(String[] args) throws Exception{
		// initialize the key store
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// should output be ASCII or binary
		boolean asciiArmor = true;
		
		// export
		keyStore.exportPrivateKey("examples/DataFiles/exported_sec.asc", "demo2@didisoft.com", asciiArmor);		
	}
}
