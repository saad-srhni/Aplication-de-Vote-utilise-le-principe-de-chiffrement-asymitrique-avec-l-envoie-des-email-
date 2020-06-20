package openpgp.revocation;


import com.didisoft.pgp.RevocationLib;

/** 
 * This example program shows how to revoke a User ID 
 * signature from an OpenPGP key file.
 */
public class RevokeUserIdSignature {
    public static void main(String args[]) throws Exception {
        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // User ID string that will revoked
        String UserId = "RSA_1";
        
        // public key containing the User ID signature
        String targetPublicKey = path + "key1_public.asc";
        
        // private key corresponding to the public key
        String targetPrivateKey = path + "key1_private.asc";
        String targetPrivateKeyPassword = ""; // empty password 
        
        // revocation reason and description
        byte revocationCode = RevocationLib.REASON_USER_NO_LONGER_USED;
        String revocationDescription = "This User is not connected any more with this key";
        
        // revoke key with revocation certificate
        lib.revokeUserIdSignature(targetPublicKey, 
                                    targetPrivateKey, 
                                    targetPrivateKeyPassword, 
                                    UserId, 
                                    revocationCode, 
                                    revocationDescription);        
    }
}
