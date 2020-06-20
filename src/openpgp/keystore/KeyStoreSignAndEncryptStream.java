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
 * This examples demonstrates how to sign and encrypt a stream in one pass 
 * using keys stored in a Key store. 
 */
public class KeyStoreSignAndEncryptStream {
	public static void main(String[] args) throws Exception{
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");		

		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		// is output ASCII or binary
        boolean asciiArmor = true; 
        // should integrity check information be added
        boolean withIntegrityCheck = true; 
		
		// The signing key is usually our private key
		String signUserId = "demo@didisoft.com";
		String signKeyPassword = "changeit";		
		// the User Id of the recipient, this  
		// example assumes her public key is
		// already imported in the KeyStore file
		String encUserId = "demo2@didisoft.com";
		
		InputStream dataStream = new FileInputStream("examples/DataFiles/INPUT.txt");
		// this parameter is just a label that is associated with
		// the encrypted content in the OpenPGP archive
		String encryptedContentLabel = "INPUT.txt";
		
		// create the output stream
		OutputStream encryptedStream = new FileOutputStream("examples/DataFiles/encrypted.pgp");
		
		pgp.signAndEncryptStream(dataStream,
								encryptedContentLabel,
				              	keyStore,
				              	signUserId,
				              	signKeyPassword,
				              	encUserId,
				              	encryptedStream,                                  
				              	asciiArmor, 
				              	withIntegrityCheck);
	}
}
