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
 * This example demonstrates how to encrypt an input stream.
 * The recipient public key is located in a KeyStore object.
 * 
 * The output and the key file are also passed as streams, this way  
 * we are not limited only to files, but can encrypt other sources -
 * for example database Blob fields. 
 */
public class KeyStoreEncryptStream {
	public static void main(String[] args) throws Exception{
		
		// create an instance of the KeyStore
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");

		String recipientUserId = "demo@didisoft.com";
		
		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		// is output ASCII or binary
        boolean asciiArmor = true; 
        // should integrity check information be added
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = false; 
        
        // obtain the streams 
        InputStream inStream = new FileInputStream("examples/DataFiles/INPUT.txt");
        OutputStream outStream = new FileOutputStream("examples/DataFiles/encrypted.pgp");
        
        // Here "INPUT.txt" is just a string to be written in the message OpenPGP packet
        // The message packet is a mandatory component of the pgp file internals and holds:
        // file name string, timestamp, and the actual data bytes
        pgp.encryptStream(inStream, "INPUT.txt", 
        				keyStore, 
        				recipientUserId, 
        				outStream, 
        				asciiArmor, 
        				withIntegrityCheck);
	}
}
