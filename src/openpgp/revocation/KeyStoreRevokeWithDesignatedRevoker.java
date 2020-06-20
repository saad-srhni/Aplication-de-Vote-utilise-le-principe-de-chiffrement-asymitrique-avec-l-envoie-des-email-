package openpgp.revocation;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.RevocationLib;

/**
 * In this example we revoke a public key located in a KeyStore 
 * with the private key a previously assigned designated revoker key.
 */
public class KeyStoreRevokeWithDesignatedRevoker {
    public static void main(String args[]) throws Exception {        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // initialize the KeyStore
        KeyStore keyStore = new KeyStore(path + "revocation.keystore", "changeit");
        keyStore.importKeyRing(path + "key1_public_assigned.asc");
        keyStore.importKeyRing(path + "key2_private.asc");
        
        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // in this example we reference the keys in the KeyStore through their User ID's.
        // but overloaded methods exist for Key ID's too
        String targetKeyUserId = "RSA_1";
        String designatedRevokerUserId = "RSA_2";
        String designatedRevokerPrivateKeyPassword = ""; // empty password 
        
        // reason and description
        byte revocationCode = RevocationLib.REASON_KEY_NO_LONGER_USED;
        String revocationDescription = "This key is no longer used";
        
        // revoke key with revocation certificate
        lib.revokeKeyWithDesignatedRevoker(keyStore, 
                                        targetKeyUserId, 
                                        designatedRevokerUserId,
                                        designatedRevokerPrivateKeyPassword, 
                                        revocationCode, 
                                        revocationDescription);        
    }
}
