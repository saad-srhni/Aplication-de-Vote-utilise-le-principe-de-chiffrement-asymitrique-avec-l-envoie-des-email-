package openpgp.revocation;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.RevocationLib;

/**
 * This example demonstrates how to revoke an OpenPGP public key 
 * located in a KeyStore file.
 */
public class KeyStoreRevokeKey {

    public static void main(String[] args) throws Exception {
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // create an instance of the library
        RevocationLib lib = new RevocationLib();

        // initialize the KeyStore
        KeyStore keyStore = new KeyStore(path + "revocation.keystore", "changeit");
        // public key and corresponding private key
        keyStore.importKeyRing(path + "key1_public.asc");
        keyStore.importKeyRing(path + "key1_private.asc");
        
        String targetKeyUserId = "RSA_1";        
        String targetPrivateKeyPassword = ""; // empty password 
        
        // revocation reason and description
        byte revocationCode = RevocationLib.REASON_KEY_NO_LONGER_USED;
        String revocationDescription = "This key is no longer used";
        
        // revoke key directly
        lib.revokeKey(keyStore, 
                    targetKeyUserId, 
                    targetPrivateKeyPassword, 
                    revocationCode, 
                    revocationDescription);     
        
        // should the exported public key be in ASCII or binary format 
        boolean asciiArmored = true;
        
        // the exported public key is revoked and can be distributed  
        // to our partners in order to prevent its future usage
        keyStore.exportPublicKey(path + "key1_public_revoked.asc", 
                                targetKeyUserId, 
                                asciiArmored);        
    }

}
