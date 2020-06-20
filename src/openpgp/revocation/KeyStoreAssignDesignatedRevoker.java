package openpgp.revocation;


import com.didisoft.pgp.*;

/**
 * This example demonstrates how to assign a designated revoker 
 * for a given OpenPGP key which is located in a KeyStore file.
 */
public class KeyStoreAssignDesignatedRevoker {
    public static void main(String[] args) throws Exception {
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // initialize the KeyStore
        KeyStore keyStore = new KeyStore(path + "revocation.keystore", "changeit");
        keyStore.importKeyRing(path + "key1_public.asc");
        keyStore.importKeyRing(path + "key1_private.asc");
        keyStore.importKeyRing(path + "key2_public.asc");
        
        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // in this example we reference the keys in the KeyStore through their User ID's,
        // but overloaded methods exist for Key ID's too
        String targetKeyUserId = "RSA_1";
        String targetPrivateKeyPassword = ""; // empty password 
        String designatedRevokerUserId = "RSA_2";
        
        // assign designated revoker
        lib.assignDesignatedRevoker(keyStore,
                                    targetKeyUserId, 
                                    targetPrivateKeyPassword,  
                                    designatedRevokerUserId);
        
        // should the exported public key be in ASCII or binary format 
        boolean asciiArmored = true;
        // the exported public key contains the designated revoker signature
        keyStore.exportPublicKey(path + "key1_public_assigned.asc", 
                                targetKeyUserId, 
                                asciiArmored);
    }
}
