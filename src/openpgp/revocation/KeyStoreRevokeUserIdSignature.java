package openpgp.revocation;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.RevocationLib;

/** 
 * The following example program shows how to revoke a User ID 
 * signature from an OpenPGP key located in a KeyStore.
 */
public class KeyStoreRevokeUserIdSignature {
    public static void main(String args[]) throws Exception {
        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // initialize the KeyStore
        KeyStore keyStore = new KeyStore(path + "revocation.keystore", "changeit");
        // public key and corresponding private key
        keyStore.importKeyRing(path + "key1_public.asc");
        keyStore.importKeyRing(path + "key1_private.asc");
        
        // User ID signature to be revoked
        String targetKeyUserId = "RSA_1";        
        String targetPrivateKeyPassword = ""; // empty password 
        
        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // revocation reason and description
        byte revocationCode = RevocationLib.REASON_USER_NO_LONGER_USED;
        String revocationDescription = "This User is not connected any more with this key";
        
        // revoke key with revocation certificate
        lib.revokeUserIdSignature(keyStore, 
                                    targetKeyUserId, 
                                    targetPrivateKeyPassword, 
                                    revocationCode, 
                                    revocationDescription);        
        
     // should the exported public key be in ASCII or binary format 
        boolean asciiArmored = true;
        
        // the exported public key contains the revoked signature 
        keyStore.exportPublicKey(path + "key1_public_user_id_revoked.asc", 
                                targetKeyUserId, 
                                asciiArmored);         
    }
}
