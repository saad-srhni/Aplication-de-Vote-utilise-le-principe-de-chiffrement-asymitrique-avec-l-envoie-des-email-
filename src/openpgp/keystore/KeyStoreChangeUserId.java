package openpgp.keystore;/*
 * Copyright 2013 DidiSoft Ltd. All Rights Reserved.
 */

import com.didisoft.pgp.KeyPairInformation;
import com.didisoft.pgp.KeyStore;

/**
 * This example shows how to manipulate the user Id signatures of a key
 */
public class KeyStoreChangeUserId {

	public static void main(String[] args) throws Exception {
		
		// initialize a new in-memory key store
		KeyStore ks = new KeyStore();
		
		ks.importPublicKey("examples/DataFiles/public.key");
		KeyPairInformation[] keys = ks.importPrivateKey("examples/DataFiles/private.key");

		long keyId = keys[0].getKeyID();
		String privateKeyPassword = "changeit";
		
		// add an additional user id to the key 
		ks.addUserId(keyId, privateKeyPassword, "didisoft_test");
		
		// modify the newly added user id 
		boolean userIdAdded = 
				ks.changeUserId(keyId, 
								privateKeyPassword, 
								"didisoft_test", 
								"didisoft_test2");
		
		// modify the primary (first) user id of the key
		ks.changePrimaryUserId(keyId, privateKeyPassword, "new_user_id");
		
		boolean userIdDeleted = ks.deleteUserId(keyId, "new_user_id");
	}
}
