package openpgp.revocation;

import com.didisoft.pgp.*;

/**
 * This example program demonstrates how to revoke an OpenPGP public key file
 */
public class RevokeKey {

    public static void main(String args[]) throws Exception {
        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // public key to be revoked
        String targetPublicKey = path + "key1_public.asc";
        
        // private key corresponding to the public key we want 
        // to revoke
        String targetPrivateKey = path + "key1_private.asc";
        String targetPrivateKeyPassword = ""; // empty password 
        
        // revocation reason and description
        byte revocationCode = RevocationLib.REASON_KEY_NO_LONGER_USED;
        String revocationDescription = "This key is no longer used";
        
        // revoke key directly
        lib.revokeKey(targetPublicKey, 
                    targetPrivateKey, 
                    targetPrivateKeyPassword, 
                    revocationCode, 
                    revocationDescription);        
    }
}
