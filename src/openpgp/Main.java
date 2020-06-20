/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */

package openpgp;
import java.io.File;

import openpgp.keystore.ChangePrivateKeyPassword;
import openpgp.keystore.ExportPrivateKey;
import openpgp.keystore.ExportPublicKey;
import openpgp.keystore.GenerateKeyPairDHDSS;
import openpgp.keystore.GenerateKeyPairRSA;
import openpgp.keystore.ImportPrivateKey;
import openpgp.keystore.ImportPublicKey;
import openpgp.keystore.KeystoreDecryptAndVerifyFile;
import openpgp.keystore.KeystoreDecryptFile;
import openpgp.keystore.KeystoreEncryptFile;
import openpgp.keystore.KeystoreListKeys;
import openpgp.keystore.KeystoreSignAndEncryptFile;

/**
 * Demonstrates usage of DidiSoft OpenPGP Library for Java. 
 */
public class Main {

	public static void print(String message){
		System.out.println();
		System.out.println(message);
	}
	
	public static void main(String[] args) throws Exception {
        print("***************************************************");
        print("*** OpenPGP Library for Java Demonstration ");
        print("***************************************************");
	    //
		// Encryption and Decryption
		//
		print("Encrypt file.");		
		EncryptFile.main(args);
		print("Decrypt file.");
//		DecryptFile.main(args);		
		
		//
		// Encryption and Decryption with Signature
		//
		print("Sign and Encrypt file.");
		SignAndEncryptFile.main(args);
		print("Decrypt and Verify file.");
		//DecryptAndVerify.main(args);

		print("Sign and Encrypt file (old OpenPGP format version 3).");
		SignAndEncryptFileV3.main(args);
		print("Decrypt and Verify file (old OpenPGP format version 3).");
		//DecryptAndVerify.main(args);
		
		//
		// Only Signature
		//
		print("Sign file.");
		SignFile.main(args);
		print("Verify file.");
		VerifyFile.main(args);

		print("Sign file (old OpenPGP format version 3).");
		SignFileV3.main(args);
		print("Verify file (old OpenPGP format version 3).");
		VerifyFile.main(args);

		print("Clear sign file.");
		ClearSignFile.main(args);
		print("Verify clear signed file.");
		ClearSignedFileVerify.main(args);
		
		//
		// Delete key store from previous demo run
		//
		File keyStore = new File("pgp.keystore");
		if (keyStore.exists()) {
			keyStore.delete();
		}
		
		//
		// Import keys demo
		//
		print("Import Private Key.");
		ImportPrivateKey.main(args);
		print("Import Public Key.");
		ImportPublicKey.main(args);

		//
		// Generate keys demo
		//
		print("Generate Key Pair.");
		GenerateKeyPairRSA.main(args);
		GenerateKeyPairDHDSS.main(args);
		
		print("Encrypt File with Keystore.");
		KeystoreEncryptFile.main(args);
		print("Decrypt File with Keystore.");
		KeystoreDecryptFile.main(args);
		
		print("Sign and Encrypt File with Keystore.");
		KeystoreSignAndEncryptFile.main(args);
		print("Decrypt and Verify File with Keystore.");
		KeystoreDecryptAndVerifyFile.main(args);
		
		//
		// Export keys demo
		//
		ExportPublicKey.main(args);
		ExportPrivateKey.main(args);
		
		ChangePrivateKeyPassword.main(args);
		
		KeystoreListKeys.main(args);
		
		//
		// Delete key pair
		//
		DeleteKeyPair.main(args);
		print("***************************************************");
		print("*** OpenPGP Library for Java Demonstration END ");
		print("***************************************************");
	}
}