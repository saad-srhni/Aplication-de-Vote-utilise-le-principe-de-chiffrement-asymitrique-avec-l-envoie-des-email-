package openpgp.revocation;

import com.didisoft.pgp.RevocationLib;

/**
 * In this example we revoke a public key file with the private key file
 * of a previously assigned designated revoker key.
 */
public class RevokeWithDesignatedRevoker {
    public static void main(String args[]) throws Exception {
        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // public key to be revoked
        String targetPublicKey = path + "key1_public.asc";
        
        // designated revoker private key 
        String designatedRevokerPrivateKey = path + "key2_private.asc";
        String designatedRevokerPrivateKeyPassword = ""; // empty password 
        
        // reason and description
        byte revocationCode = RevocationLib.REASON_KEY_NO_LONGER_USED;
        String revocationDescription = "This key is no longer used";
        
        // revoke key with revocation certificate
        lib.revokeKeyWithDesignatedRevoker(targetPublicKey, 
                                        designatedRevokerPrivateKey, 
                                        designatedRevokerPrivateKeyPassword, 
                                        revocationCode, 
                                        revocationDescription);        
    }
}
